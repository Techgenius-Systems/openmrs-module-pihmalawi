/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.pihmalawi.reporting.reports;

import org.openmrs.module.pihmalawi.PihMalawiConstants;
import org.openmrs.module.pihmalawi.metadata.HivMetadata;
import org.openmrs.module.reporting.common.DateUtil;
import org.openmrs.module.reporting.evaluation.EvaluationContext;
import org.openmrs.module.reporting.report.manager.ReportManager;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Tests the TraceReport
 */
public class MedicMobileIC3TraceReportTest extends ReportManagerTest {

	@Autowired
    MedicMobileIC3TraceReport report;

	@Override
	public ReportManager getReportManager() {
		return report;
	}

    @Override
    public void performTest() throws Exception {
        String url = "jdbc:mysql://localhost:3306/openmrs_neno_warehouse?autoReconnect=true&sessionVariables=storage_engine%3DInnoDB&useUnicode=true&characterEncoding=UTF-8";
        String user = "openmrs";
        String password = "openmrs";

        File propertiesFile = new File(OpenmrsConstants.APPLICATION_DATA_DIRECTORY_RUNTIME_PROPERTY, PihMalawiConstants.OPENMRS_WAREHOUSE_CONNECTION_PROPERTIES_FILE_NAME);
        Properties properties = new Properties();
        properties.put("connection.url", url);
        properties.put("connection.username", user);
        properties.put("connection.password", password);
        properties.store(new FileOutputStream(propertiesFile), null);

        super.performTest();
    }

    @Override
	public EvaluationContext getEvaluationContext() {
		EvaluationContext context = new EvaluationContext();
		context.addParameterValue("endDate", DateUtil.getDateTime(2017, 3, 16));
		context.addParameterValue("labWeeks",6);
		return context;
	}

	@Override
	protected boolean isEnabled() {
		return true;
	}

	@Override
	public boolean enableReportOutput() {
		return true;
	}
}
