package com.example.animal_health;
import com.google.firebase.database.IgnoreExtraProperties;
public class Hospital {
    private String BIZCOND_DIV_NM_INFO, BIZPLC_NM,BSN_STATE_DIV_CD,BSN_STATE_NM,CLSBIZ_DE,LICENSG_CANCL_DE,LICENSG_DE,LOCPLC_AR_INFO,LOCPLC_FACLT_TELNO,
            REFINE_LOTNO_ADDR,REFINE_ROADNM_ADDR,REFINE_WGS84_LAT,REFINE_WGS84_LOGT,REFINE_ZIP_CD,RIGHT_MAINBD_IDNTFY_NO,ROADNM_ZIP_CD,SIGUN_NM,STOCKRS_DUTY_DIV_NM,
            STOCKRS_IDNTFY_NO,X_CRDNT_VL, Y_CRDNT_VL;

    public Hospital(){

    }

    public Hospital(String BIZCOND_DIV_NM_INFO, String BIZPLC_NM, String BSN_STATE_DIV_CD, String BSN_STATE_NM, String CLSBIZ_DE, String LICENSG_CANCL_DE,
                    String LICENSG_DE, String LOCPLC_AR_INFO, String LOCPLC_FACLT_TELNO, String REFINE_LOTNO_ADDR,
                    String REFINE_ROADNM_ADDR,String REFINE_WGS84_LAT,String REFINE_WGS84_LOGT,String REFINE_ZIP_CD,String RIGHT_MAINBD_IDNTFY_NO,
                    String ROADNM_ZIP_CD,String SIGUN_NM,String STOCKRS_DUTY_DIV_NM,String STOCKRS_IDNTFY_NO,String X_CRDNT_VL,String Y_CRDNT_VL) {
        this.BIZCOND_DIV_NM_INFO = BIZCOND_DIV_NM_INFO;
        this.BIZPLC_NM = BIZPLC_NM;
        this.BSN_STATE_DIV_CD = BSN_STATE_DIV_CD;
        this.BSN_STATE_NM = BSN_STATE_NM;
        this.CLSBIZ_DE = CLSBIZ_DE;
        this.LICENSG_CANCL_DE = LICENSG_CANCL_DE;
        this.LICENSG_DE = LICENSG_DE;
        this.LOCPLC_AR_INFO = LOCPLC_AR_INFO;
        this.BSN_STATE_NM = BSN_STATE_NM;
        this. LOCPLC_FACLT_TELNO =  LOCPLC_FACLT_TELNO;

        this.REFINE_LOTNO_ADDR = REFINE_LOTNO_ADDR;
        this.REFINE_ROADNM_ADDR = REFINE_ROADNM_ADDR;
        this.REFINE_WGS84_LAT = REFINE_WGS84_LAT;
        this.REFINE_WGS84_LOGT = REFINE_WGS84_LOGT;
        this. RIGHT_MAINBD_IDNTFY_NO =  RIGHT_MAINBD_IDNTFY_NO;

        this.REFINE_ZIP_CD = REFINE_ZIP_CD;
        this.SIGUN_NM = SIGUN_NM;
        this.STOCKRS_DUTY_DIV_NM = STOCKRS_DUTY_DIV_NM;
        this.STOCKRS_IDNTFY_NO = STOCKRS_IDNTFY_NO;
        this. X_CRDNT_VL =  X_CRDNT_VL;
        this. Y_CRDNT_VL =  Y_CRDNT_VL;

    }

    public String getBIZCOND_DIV_NM_INFO() {
        return BIZCOND_DIV_NM_INFO;
    }

    public String getBIZPLC_NM() {
        return BIZPLC_NM;
    }


    public String getBSN_STATE_DIV_CD() {
        return BSN_STATE_DIV_CD;
    }

    public String getBSN_STATE_NM() {
        return BSN_STATE_NM;
    }

    public String getCLSBIZ_DE() {
        return CLSBIZ_DE;
    }


    public String getLICENSG_CANCL_DE() {
        return LICENSG_CANCL_DE;
    }

    public String getLICENSG_DE() {
        return LICENSG_DE;
    }

    public String getLOCPLC_AR_INFO() {
        return LOCPLC_AR_INFO;
    }

    public String getLOCPLC_FACLT_TELNO() {
        return LOCPLC_FACLT_TELNO;
    }

    public String getREFINE_LOTNO_ADDR() {
        return REFINE_LOTNO_ADDR;
    }

    public String getREFINE_ROADNM_ADDR() {
        return  REFINE_ROADNM_ADDR;
    }

    public String getREFINE_WGS84_LAT() {
        return  REFINE_WGS84_LAT;
    }
    public String getREFINE_WGS84_LOGT() {
        return  REFINE_WGS84_LOGT;
    }
    public String getREFINE_ZIP_CD() {
        return  REFINE_ZIP_CD;
    }
    public String getRIGHT_MAINBD_IDNTFY_NO() {
        return  RIGHT_MAINBD_IDNTFY_NO;
    }
    public String getROADNM_ZIP_CD() {
        return  ROADNM_ZIP_CD;
    }

    public String getSIGUN_NM() {
        return  SIGUN_NM;
    }
    public String getSTOCKRS_DUTY_DIV_NM() {
        return  ROADNM_ZIP_CD;
    }
    public String getSTOCKRS_IDNTFY_NO() {
        return  STOCKRS_IDNTFY_NO;
    }
    public String getX_CRDNT_VL() {
        return  X_CRDNT_VL;
    }
    public String getY_CRDNT_VL() {
        return  Y_CRDNT_VL;
    }



}