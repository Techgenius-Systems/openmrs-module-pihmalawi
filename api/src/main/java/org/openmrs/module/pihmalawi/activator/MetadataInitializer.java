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
package org.openmrs.module.pihmalawi.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.metadatadeploy.bundle.MetadataBundle;

import java.util.Locale;

public class MetadataInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(MetadataInitializer.class);

	/**
	 * @see Initializer#started()
	 */
	@Override
	public synchronized void started() {

        MetadataDeployService deployService = Context.getService(MetadataDeployService.class);
        deployService.installBundles(Context.getRegisteredComponents(MetadataBundle.class));

		// TODO: Clean this up.  One option:
		// Create some scripts that:
		//  select all concepts associated with obs, programs, etc. as well as the answers and sets associated with them
		//  organize these by datatype and class
		// Do the same for other metadata (encounter types, etc)
		// Export these out as a series of CSVs
		//
		// Create generated source / class files for these via maven plugin
		// Associate with versions and

		ConceptService cs = Context.getConceptService();
		{
			Integer id = 8417;
			String uuid = "521f8e75-4113-4870-bcbb-9ec1d727c627";
			String name = "Chronic Care Medication Set";
			Concept c = cs.getConceptByUuid(uuid);
			if (c == null) {
				log.warn("Creating Chronic Care Medication Set");
				c = new Concept();
				c.setConceptId(id);
				c.setUuid(uuid);
				c.setConceptClass(cs.getConceptClassByName("MedSet"));
				c.setDatatype(cs.getConceptDatatypeByName("N/A"));
				c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
				c.setSet(true);
				c.addSetMember(cs.getConceptByName("Salbutamol"));
				c.addSetMember(cs.getConceptByName("Beclomethasone"));
				c.addSetMember(cs.getConceptByName("Hydrochlorothiazide"));
				c.addSetMember(cs.getConceptByName("Captopril"));
				c.addSetMember(cs.getConceptByName("Amlodipine"));
				c.addSetMember(cs.getConceptByName("Enalapril"));
				c.addSetMember(cs.getConceptByName("Nifedipine"));
				c.addSetMember(cs.getConceptByName("Atenolol"));
				c.addSetMember(cs.getConceptByName("Lisinopril"));
				c.addSetMember(cs.getConceptByName("Propranolol"));
				c.addSetMember(cs.getConceptByName("Phenobarbital"));
				c.addSetMember(cs.getConceptByName("Phenytoin"));
				c.addSetMember(cs.getConceptByName("Carbamazepine"));
				c.addSetMember(cs.getConceptByName("Insulin"));
				c.addSetMember(cs.getConceptByName("Metformin"));
				c.addSetMember(cs.getConceptByName("Glibenclamide"));
				c.addSetMember(cs.getConceptByName("Furosemide"));
				c.addSetMember(cs.getConceptByName("Spironolactone"));
				cs.saveConcept(c);
			}
		}
		{
			Integer id = 6872;
			String name = "Hypertension Medication Set";
			Concept c = cs.getConcept(id);
			if (c.getFullySpecifiedName(Locale.ENGLISH).getName().equals("Hypertension medication")) {
				log.warn("Updating " + name);
				c.setConceptClass(cs.getConceptClassByName("MedSet"));
				c.setDatatype(cs.getConceptDatatypeByName("N/A"));
				c.getFullySpecifiedName(Locale.ENGLISH).setName(name);
				c.setSet(true);
				c.getConceptSets().clear();
				c.addSetMember(cs.getConceptByName("Hydrochlorothiazide"));
				c.addSetMember(cs.getConceptByName("Captopril"));
				c.addSetMember(cs.getConceptByName("Amlodipine"));
				c.addSetMember(cs.getConceptByName("Enalapril"));
				c.addSetMember(cs.getConceptByName("Nifedipine"));
				c.addSetMember(cs.getConceptByName("Atenolol"));
				c.addSetMember(cs.getConceptByName("Lisinopril"));
				c.addSetMember(cs.getConceptByName("Propranolol"));
				cs.saveConcept(c);
			}
		}
		{
			{
				Integer id = 8418;
				String uuid = "5ea979aa-1369-11e4-a125-54ee7513a7ff";
				String name = "Substance abuse";
				Concept c = cs.getConcept(id);
				if (c == null) {
					log.warn("Creating " + name);
					c = new Concept();
					c.setConceptId(id);
					c.setUuid(uuid);
					c.setConceptClass(cs.getConceptClassByName("Diagnosis"));
					c.setDatatype(cs.getConceptDatatypeByName("N/A"));
					c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
					cs.saveConcept(c);
				}
			}
		}
		{
			{
				Integer id = 8419;
				String uuid = "93e9be37-1369-11e4-a125-54ee7513a7ff";
				String name = "Acute Psychotic disorder";
				Concept c = cs.getConcept(id);
				if (c == null) {
					log.warn("Creating " + name);
					c = new Concept();
					c.setConceptId(id);
					c.setUuid(uuid);
					c.setConceptClass(cs.getConceptClassByName("Diagnosis"));
					c.setDatatype(cs.getConceptDatatypeByName("N/A"));
					c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
					cs.saveConcept(c);
				}
			}
		}
		{
			{
				Integer id = 8420;
				String uuid = "aad4c0e9-1369-11e4-a125-54ee7513a7ff";
				String name = "Other Mental Health Diagnosis non-coded";
				Concept c = cs.getConcept(id);
				if (c == null) {
					log.warn("Creating " + name);
					c = new Concept();
					c.setConceptId(id);
					c.setUuid(uuid);
					c.setConceptClass(cs.getConceptClassByName("Diagnosis"));
					c.setDatatype(cs.getConceptDatatypeByName("N/A"));
					c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
					cs.saveConcept(c);
				}
			}
		}
		{

            Integer id = 3683;

			Concept c = cs.getConcept(id);
			log.warn("Updating answers for Chronic Care Diagnosis");
			c.getAnswers().clear();
			c.addAnswer(new ConceptAnswer(cs.getConcept(5)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(903)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(155)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(3720)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(3468)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(7623)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(6421)));
			c.addAnswer(new ConceptAnswer(cs.getConcept(207))); // Depression
			c.addAnswer(new ConceptAnswer(cs.getConcept(8418))); // Substance abuse
			c.addAnswer(new ConceptAnswer(cs.getConcept(8419))); // Acute psychotic disorder
			c.addAnswer(new ConceptAnswer(cs.getConcept(8420))); // Other mental health diagnosis
			c.addAnswer(new ConceptAnswer(cs.getConcept(5622))); // Other non-coded
			cs.saveConcept(c);

		}

        {
            {
                Integer id = 8421;
                String uuid = "f792f2f9-9c24-4d6e-98fd-caffa8f2383f";
                String name = "Sample taken for Viral Load";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Boolean"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }

        {
            {
                Integer id = 8426;
                String uuid = "37519f36-8c2e-11e5-80a3-c0430f805837";
                String name = "Asthma family history";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Coded"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    c.addAnswer(new ConceptAnswer(cs.getConcept(703))); // positive
                    c.addAnswer(new ConceptAnswer(cs.getConcept(664))); // negative
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1067))); // unknown
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8427;
                String uuid = "41afdae4-8c31-11e5-80a3-c0430f805837";
                String name = "COPD family history";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Coded"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    c.addAnswer(new ConceptAnswer(cs.getConcept(703))); // positive
                    c.addAnswer(new ConceptAnswer(cs.getConcept(664))); // negative
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1067))); // unknown
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8428;
                String uuid = "6df61adc-8c31-11e5-80a3-c0430f805837";
                String name = "Age at cough onset";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8429;
                String uuid = "fd9e5898-8c31-11e5-80a3-c0430f805837";
                String name = "Date of contact with TB+ person";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Date"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8430;
                String uuid = "6780fd96-8c33-11e5-80a3-c0430f805837";
                String name = "Occupational exposure";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Boolean"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8431;
                String uuid = "941bc17e-8c33-11e5-80a3-c0430f805837";
                String name = "Name of community health worker";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Text"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8432;
                String uuid = "af397d66-8c33-11e5-80a3-c0430f805837";
                String name = "Last time person used tobacco";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Date"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8433;
                String uuid = "cf066e56-8c33-11e5-80a3-c0430f805837";
                String name = "Last time person was exposed to second hand smoke";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Date"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8434;
                String uuid = "ec4c3db0-8c33-11e5-80a3-c0430f805837";
                String name = "Date of last exposure to occupational hazard";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Misc"));
                    c.setDatatype(cs.getConceptDatatypeByName("Date"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8435;
                String uuid = "0bea98a6-8c34-11e5-80a3-c0430f805837";
                String name = "Is the visit planned?";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Coded"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1065))); // yes
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1066))); // no                    
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8436;
                String uuid = "257fb56c-8c34-11e5-80a3-c0430f805837";
                String name = "Daytime symptom frequency";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8437;
                String uuid = "53e5e188-8c34-11e5-80a3-c0430f805837";
                String name = "Nighttime symptom frequency";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8438;
                String uuid = "79a37b88-8c34-11e5-80a3-c0430f805837";
                String name = "Number of times inhaler is used in a day";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8439;
                String uuid = "baf99a7c-8c34-11e5-80a3-c0430f805837";
                String name = "Number of times inhaler is used in a week";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8440;
                String uuid = "b60d8d98-8c34-11e5-80a3-c0430f805837";
                String name = "Number of times inhaler is used in a month";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8441;
                String uuid = "af73fa84-8c35-11e5-80a3-c0430f805837";
                String name = "Number of times inhaler is used in a year";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8442;
                String uuid = "359808c6-8c36-11e5-80a3-c0430f805837";
                String name = "Number of times steroid inhaler is used in a day";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Numeric"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));                 
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8443;
                String uuid = "e51be8fa-8c34-11e5-80a3-c0430f805837";
                String name = "Exposed to second hand smoke?";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Coded"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));    
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1065))); // yes
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1066))); // no                     
                    cs.saveConcept(c);
                }
            }
        }
        {
            {
                Integer id = 8444;
                String uuid = "2198f6d8-8c35-11e5-80a3-c0430f805837";
                String name = "Asthma exacerbation today?";
                Concept c = cs.getConcept(id);
                if (c == null) {
                    log.warn("Creating " + name);
                    c = new Concept();
                    c.setConceptId(id);
                    c.setUuid(uuid);
                    c.setConceptClass(cs.getConceptClassByName("Question"));
                    c.setDatatype(cs.getConceptDatatypeByName("Coded"));
                    c.setFullySpecifiedName(new ConceptName(name, Locale.ENGLISH));    
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1065))); // yes
                    c.addAnswer(new ConceptAnswer(cs.getConcept(1066))); // no                     
                    cs.saveConcept(c);
                }
            }
        }

    }

	@Override
	public void stopped() {
	}
}