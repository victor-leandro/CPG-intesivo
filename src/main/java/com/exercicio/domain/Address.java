package com.exercicio.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @Column(name = "cep")
    private String cep;

    @Column(name = "address_number")
    private String number;

    @Column(name = "full_address")
    private String complement;

    @Column(name = "adress_district")
    private String district;

    @Column
    private Long codeIBGE;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "adress_city_id")
    private City city;
}
