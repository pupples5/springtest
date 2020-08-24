package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@ToString
@Getter
@Entity
public class wkplInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String wkplNm;
    private String bzowrRgstNo;
    private String wkplRoadNmDtlAddr;
    private int wkplJnngStcd;
    private int ldongAddrMgplDgCd;
    private int ldongAddrMgplSgguCd;
    private int wkplStylDvcd;
    private String wkplIntpCd;
    private String vldtVlKrnNm;
    private Date adptDt;
    private Date scsnDt;
    private int jnngpCnt;
    private int crrmmNtcAmt;


    @Builder
    public wkplInfo(Long no, String wkplNm, String bzowrRgstNo, String wkplRoadNmDtlAddr, int wkplJnngStcd, int ldongAddrMgplDgCd, int ldongAddrMgplSgguCd, int wkplStylDvcd, String wkplIntpCd, String vldtVlKrnNm, Date adptDt, Date scsnDt, int jnngpCnt, int crrmmNtcAmt) {
        this.no = no;
        this.wkplNm = wkplNm;
        this.bzowrRgstNo = bzowrRgstNo;
        this.wkplRoadNmDtlAddr = wkplRoadNmDtlAddr;
        this.wkplJnngStcd = wkplJnngStcd;
        this.ldongAddrMgplDgCd = ldongAddrMgplDgCd;
        this.ldongAddrMgplSgguCd = ldongAddrMgplSgguCd;
        this.wkplStylDvcd = wkplStylDvcd;
        this.wkplIntpCd = wkplIntpCd;
        this.vldtVlKrnNm = vldtVlKrnNm;
        this.adptDt = adptDt;
        this.scsnDt = scsnDt;
        this.jnngpCnt = jnngpCnt;
        this.crrmmNtcAmt = crrmmNtcAmt;
    }


}
