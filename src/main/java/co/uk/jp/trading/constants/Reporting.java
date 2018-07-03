/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.constants;


public class Reporting {

    /*Generic report parameters*/
    public static final String REPORT_HEADER_BLANK_LINE = "------------------------------------------\n";

    /* Ranking report header parameters*/
    public static final String DAILY_INCOMING_RANKING_REPORT_HEADER_LINE2 = "       Daily Incoming Ranking Report      \n";
    public static final String DAILY_OUTGOING_RANKING_REPORT_HEADER_LINE2 = "       Daily Outgoing Ranking Report      \n";
    public static final String DAILY_RANKING_REPORT_HEADER_LINE4 = "Date         |   Rank     |   Entity      \n";

    /* Amount Settlement report header parameters*/
    public static final String DAILY_INCOMING_AMOUNT_SETTLEMENT_REPORT_HEADER_LINE2 = "       Daily Incoming AMOUNT SETTLEMENT Report      \n";
    public static final String DAILY_OUTGOING_AMOUNT_SETTLEMENT_REPORT_HEADER_LINE2 = "       Daily Outgoing AMOUNT SETTLEMENT Report      \n";
    public static final String DAILY_AMOUNT_SETTLEMENT_REPORT_HEADER_LINE4 = "Date             |      Trade Amount      \n";
}
