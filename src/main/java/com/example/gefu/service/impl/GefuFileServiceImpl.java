package com.example.gefu.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gefu.domain.File;
import com.example.gefu.domain.FileFormat;
import com.example.gefu.dto.GefuFooterDTO;
import com.example.gefu.dto.GefuHeaderDTO;
import com.example.gefu.dto.GefuTransactionDTO;
import com.example.gefu.repository.FileRepository;
import com.example.gefu.service.GefuFileService;

@Service(value = "gefuFileService")
public class GefuFileServiceImpl implements GefuFileService {

	private @Autowired FileRepository fileRepository;

	public List<File> getFiles() {
		return fileRepository.getValidRecords();
	}

	public void generateGefu(File file) {
		StreamFactory factory = StreamFactory.newInstance();
		// load the mapping file
		factory.loadResource("mapping.xml");

		String fileName = "/home/krish/clayfin/junks/gefuFile_" + file.getId() + ".csv";
		// use a StreamFactory to create a BeanWriter
		BeanWriter out = factory.createWriter("gefuFile",
				new java.io.File(fileName));

		// header
		GefuHeaderDTO headerDTO = new GefuHeaderDTO();
		headerDTO.setFileDate(new Date());
		out.write("header", headerDTO);

		// transaction
		List<FileFormat> fileFormats = file.getFileFormats();
		int recordCount = 0;
		BigDecimal amount = new BigDecimal(0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

		for (FileFormat fileFormat : fileFormats) {
			GefuTransactionDTO transactionDTO = new GefuTransactionDTO();
			transactionDTO.setDebitAccountNumber(fileFormat.getDebitAccount());
			transactionDTO.setCreditAccountNumber(fileFormat.getCreditAccount());
			transactionDTO.setTransactionDate(fileFormat.getPaymentDate());
			transactionDTO.setValueDate(fileFormat.getPaymentDate());
			transactionDTO.setCurrencyCode(fileFormat.getCurrency());
			transactionDTO.setAmount(fileFormat.getAmount());
			transactionDTO.setBeneficiaryAccount(fileFormat.getBeneficiaryBank());
			transactionDTO.setRecordCount(recordCount);
			transactionDTO.setPaymentDateInWords(formatter.format(fileFormat.getPaymentDate()));
			out.write("transaction", transactionDTO);
			recordCount++;
			amount = amount.add(fileFormat.getAmount());
		}

		// footer
		GefuFooterDTO footerDTO = new GefuFooterDTO();
		footerDTO.setRecordCount(recordCount);
		footerDTO.setTotalAmount(amount);
		out.write("footer", footerDTO);

		out.flush();
		out.close();

		File f = fileRepository.findOne(file.getId());
		f.setGefuFile(fileName);
		f.setIsGefuDone("Y");
		fileRepository.save(f);
	}
}
