package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class HospitalRowDto(
    // 시군코드
    @SerializedName("SIGUN_CD")
    val sicunCode: String? = null,
    // 시군명
    @SerializedName("SIGUN_NM")
    val sicunName: String? = null,
    // 사업장명
    @SerializedName("BIZPLC_NM")
    val workplaceName: String? = null,
    // 인허가일자
    @SerializedName("LICENSG_DE")
    val licenseDate: String? = null,
    // 인허가취소일자
    @SerializedName("LICENSG_CANCL_DE")
    val licenseCancelDate: String? = null,
    // 영업상태구분코드
    @SerializedName("BSN_STATE_DIV_CD")
    val businessStateCode: String? = null,
    // 영업상태명
    @SerializedName("BSN_STATE_NM")
    val businessStateName: String? = null,
    // 폐업일자
    @SerializedName("CLSBIZ_DE")
    val closingBusinessDate: String? = null,
    // 소재지 시설 전화번호
    @SerializedName("LOCPLC_FACLT_TELNO")
    val localFactoryTelNumber: String? = null,
    // 소재지 면적 정보
    @SerializedName("LOCPLC_AR_INFO")
    val localAreaInfo: String? = null,
    // 소재지 우편번호
    @SerializedName("LOCPLC_ZIP_CD")
    val localZipCode: String? = null,
    // 도로명 우편번호
    @SerializedName("ROADNM_ZIP_CD")
    val roadNameZipCode: String? = null,
    // 도로명 주소
    @SerializedName("REFINE_ROADNM_ADDR")
    val refineRoadNameAddress: String? = null,
    // 지번 주소
    @SerializedName("REFINE_LOTNO_ADDR")
    val refineLocalAddress: String? = null,
    // 우편번호
    @SerializedName("REFINE_ZIP_CD")
    val refineZipCode: String? = null,
    // WGS84 위도
    @SerializedName("REFINE_WGS84_LAT")
    val latitude: String? = null,
    // WGS84 경도
    @SerializedName("REFINE_WGS84_LOGT")
    val longitude: String? = null,
    // 업태구분명 정보
//    @SerializedName("BIZCOND_DIV_NM_INFO")
//    val sicunCode: String? = null,
    // X 좌표값
    @SerializedName("X_CRDNT_VL")
    val xCoordinate: String? = null,
    // Y 좌표값
    @SerializedName("Y_CRDNT_VL")
    val yCoordinate: String? = null,
    // 축산업무구분명
//    @SerializedName("STOCKRS_DUTY_DIV_NM")
//    val sicunCode: String? = null,
    // 축산물 가공업 구분명
//    @SerializedName("SFRMPROD_PROCSBIZ_DIV_NM")
//    val sicunCode: String? = null,
    // 축산 고유번호
//    @SerializedName("STOCKRS_IDNTFY_NO")
//    val sicunCode: String? = null,
    // 관리주체 일련번호
//    @SerializedName("RIGHT_MAINBD_IDNTFY_NO")
//    val sicunCode: String? = null,
    // 총 종업원 수
    @SerializedName("TOT_EMPLY_CNT")
    val totalEmployeeCount: String? = null
)
