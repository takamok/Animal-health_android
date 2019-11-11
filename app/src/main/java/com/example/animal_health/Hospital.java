package com.example.animal_health;
import com.google.firebase.database.IgnoreExtraProperties;
public class Hospital {

    private String RIGHT_MAINBD_IDNTFY_NO,  ROADNM_ZIP_CD;
    private String BIZPLC_NM, REFINE_WGS84_LAT, STOCKRS_DUTY_DIV_NM, REFINE_ZIP_CD, BSN_STATE_NM;
    private String REFINE_ROADNM_ADDR,CLSBIZ_DE,BIZCOND_DIV_NM_INFO,LICENSG_DE,LOCPLC_AR_INFO,REFINE_WGS84_LOGT;

    public Hospital(){

    }

    public Hospital(String RIGHT_MAINBD_IDNTFY_NO, String BIZPLC_NM, String REFINE_ROADNM_ADDR, String CLSBIZ_DE, String BIZCOND_DIV_NM_INFO, String REFINE_WGS84_LAT,
                    String STOCKRS_DUTY_DIV_NM, String REFINE_ZIP_CD, String BSN_STATE_NM, String  ROADNM_ZIP_CD) {
        this.RIGHT_MAINBD_IDNTFY_NO = RIGHT_MAINBD_IDNTFY_NO;
        this.BIZPLC_NM = BIZPLC_NM;
        this.REFINE_ROADNM_ADDR = REFINE_ROADNM_ADDR;
        this.CLSBIZ_DE = CLSBIZ_DE;
        this.BIZCOND_DIV_NM_INFO = BIZCOND_DIV_NM_INFO;
        this.REFINE_WGS84_LAT = REFINE_WGS84_LAT;
        this.STOCKRS_DUTY_DIV_NM = STOCKRS_DUTY_DIV_NM;
        this.REFINE_ZIP_CD = REFINE_ZIP_CD;
        this.BSN_STATE_NM = BSN_STATE_NM;
        this. ROADNM_ZIP_CD =  ROADNM_ZIP_CD;
    }

    public String getHospitalId() {
        return RIGHT_MAINBD_IDNTFY_NO;
    }

    public void setSHospitalId(String RIGHT_MAINBD_IDNTFY_NO) {
        this.RIGHT_MAINBD_IDNTFY_NO = RIGHT_MAINBD_IDNTFY_NO;
    }

    public String getHospitalName() {
        return BIZPLC_NM;
    }

    public void setSHospitalName(String BIZPLC_NM) {
        this.BIZPLC_NM = BIZPLC_NM;
    }

    public String getHospital1() {
        return CLSBIZ_DE;
    }

    public void setSHospital1(String CLSBIZ_DE) {
        this.CLSBIZ_DE = CLSBIZ_DE;
    }
    public String getHospital2() {
        return BIZCOND_DIV_NM_INFO;
    }

    public void setSHospital2(String BIZCOND_DIV_NM_INFO) {
        this.BIZCOND_DIV_NM_INFO = BIZCOND_DIV_NM_INFO;
    }
    public String getHospital3() {
        return LICENSG_DE;
    }

    public void setSHospital3(String LICENSG_DE) {
        this.LICENSG_DE = LICENSG_DE;
    }

    public String getHospital4() {
        return LOCPLC_AR_INFO;
    }

    public void setSHospital4(String LOCPLC_AR_INFO) {
        this.LOCPLC_AR_INFO = LOCPLC_AR_INFO;
    }

    public String getHospitalAddress() {
        return REFINE_WGS84_LOGT;
    }

    public void setSHospitalAddress(String REFINE_WGS84_LOGT) {
        this.REFINE_WGS84_LOGT = REFINE_WGS84_LOGT;
    }

    public String getHospital5() {
        return REFINE_WGS84_LAT;
    }

    public void setSHospital5(String REFINE_WGS84_LAT) {
        this.REFINE_WGS84_LAT = REFINE_WGS84_LAT;
    }

    public String getHospital6() {
        return REFINE_ZIP_CD;
    }

    public void setSHospital6(String REFINE_ZIP_CD) {
        this.REFINE_ZIP_CD = REFINE_ZIP_CD;
    }

    public String getHospital7() {
        return BSN_STATE_NM;
    }

    public void setSHospital7(String BSN_STATE_NM) {
        this.BSN_STATE_NM = BSN_STATE_NM;
    }

    public String getHospital8() {
        return  ROADNM_ZIP_CD;
    }

    public void setSHospital8(String  ROADNM_ZIP_CD) {
        this. ROADNM_ZIP_CD =  ROADNM_ZIP_CD;
    }
}