package com.example.gefu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class GefuFooterDTO implements Serializable {

    private static final long serialVersionUID = -4858141104776053727L;

    private Integer recordCount;
    private BigDecimal totalAmount;
}
