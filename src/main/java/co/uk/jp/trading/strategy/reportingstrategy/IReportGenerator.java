/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy;

import java.util.Set;

import co.uk.jp.trading.model.Instruction;

public interface IReportGenerator {

    StringBuilder generateReport(Set<Instruction> instructions);
}
