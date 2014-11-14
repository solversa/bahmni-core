package org.bahmni.module.referencedata.labconcepts.validator;

import org.apache.commons.lang3.StringUtils;
import org.bahmni.module.referencedata.labconcepts.contract.Drug;
import org.bahmni.module.referencedata.labconcepts.model.DrugMetaData;
import org.openmrs.Concept;
import org.openmrs.ConceptClass;

import java.util.ArrayList;
import java.util.List;

public class DrugValidator extends Validator{

    private final DrugMetaDataValidator drugMetaDataValidator;

    public DrugValidator() {
        drugMetaDataValidator = new DrugMetaDataValidator();
    }

    public void validate(Drug drug, DrugMetaData drugMetaData) {
        drugMetaDataValidator.validate(drugMetaData);
        List<String> errors = new ArrayList<>();
        if (StringUtils.isBlank(drug.getName())){
            errors.add("Drug name is mandatory");
        } if (StringUtils.isBlank(drug.getGenericName())){
            errors.add("Drug generic name is mandatory");
        }
        throwExceptionIfExists(errors);
    }
}