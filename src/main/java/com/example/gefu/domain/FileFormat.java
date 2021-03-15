package com.example.gefu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "FILE_FORMAT")
public class FileFormat implements Serializable {
	private static final long serialVersionUID = -5539991760531836273L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "FILE_ID", nullable = false)
	private File file;

	@Column(name = "SLNO", nullable = false)
	private Long slNO;

	@Column(name = "PAYMENT_DATE", nullable = false)
	private Date paymentDate;

	@Column(name = "PAYMENT_TYPE", nullable = false)
	private String paymentType;

	@Column(name = "DEBIT_ACC_NO", nullable = false)
	private String debitAccount;

	@Column(name = "CREDIT_ACC_NO", nullable = false)
	private String creditAccount;

	@Column(name = "BENEFICIARY_NAME", nullable = false)
	private String beneficiaryName;

	@Column(name = "BENEFICIARY_BANK", nullable = false)
	private String beneficiaryBank;

	@Column(name = "BENEFICIARY_BANK_CODE", nullable = false)
	private String beneficiaryBankCode;

	@Column(name = "BENEFICIARY_ACC_TYPE", nullable = false)
	private String beneficiaryAccountType;

	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;

	@Column(name = "CURRENCY", nullable = false)
	private String currency;

	@Column(name = "DR_CR", nullable = false)
	private String debitOrCredit;

	@Column(name = "VALID", nullable = false)
	private Character isValid;

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
		this.isValid = isValid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Long getSlNO() {
		return slNO;
	}

	public void setSlNO(Long slNO) {
		this.slNO = slNO;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public String getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryBank() {
		return beneficiaryBank;
	}

	public void setBeneficiaryBank(String beneficiaryBank) {
		this.beneficiaryBank = beneficiaryBank;
	}

	public String getBeneficiaryBankCode() {
		return beneficiaryBankCode;
	}

	public void setBeneficiaryBankCode(String beneficiaryBankCode) {
		this.beneficiaryBankCode = beneficiaryBankCode;
	}

	public String getBeneficiaryAccountType() {
		return beneficiaryAccountType;
	}

	public void setBeneficiaryAccountType(String beneficiaryAccountType) {
		this.beneficiaryAccountType = beneficiaryAccountType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDebitOrCredit() {
		return debitOrCredit;
	}

	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
}
