package com.example.gefu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class GefuTransactionDTO implements Serializable {
    private static final long serialVersionUID = -1607726024204528120L;

    private String debitAccountNumber;
    private String creditAccountNumber;
    private Date transactionDate;
    private Date valueDate;
    private String currencyCode;
    private BigDecimal amount;
    private String beneficiaryAccount;
    private Integer recordCount;
    private String paymentDateInWords;

}
