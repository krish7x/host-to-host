package com.example.gefu.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.gefu.domain.File;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class FileFormatDTO implements Serializable {
    private static final long serialVersionUID = -8514698014643324168L;

    private Long id;
    private File file;
    private Long slNo;
    private String paymentDate;
    private String paymentType;
    private String debitAccount;
    private String creditAccount;
    private String beneficiaryName;
    private String beneficiaryBank;
    private String beneficiaryBankCode;
    private String beneficiaryAccountType;
    private BigDecimal amount;
    private String currency;
    private String debitOrCredit;
}
