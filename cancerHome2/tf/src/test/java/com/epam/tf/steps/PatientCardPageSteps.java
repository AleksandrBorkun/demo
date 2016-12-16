package com.epam.tf.steps;


import com.epam.tf.pages.PatientCardPage;
import org.openqa.selenium.WebDriver;


public class PatientCardPageSteps extends AbstractSteps {

    private PatientCardPage patientCardPage;

    public PatientCardPageSteps(WebDriver driver) {
        super(driver);
        patientCardPage = new PatientCardPage(driver);
    }

    public PassportPartArchievePageSteps choosePassportPart() {
        patientCardPage.passportPartExpand();
        patientCardPage.clickArchieveButton();
        log.info("Choose passport part");
        return new PassportPartArchievePageSteps(driver);
    }

    public MarksOnClinicalExaminationPageSteps goToMarksOnClinicalExamination() {
        log.info("go to Marks on clinical examination");
        patientCardPage.clickMarksOnClinicalExamination();
        return new MarksOnClinicalExaminationPageSteps(driver);
    }

    public PatientCardPageSteps goToDateListOfDiagnoses() {
        log.info("go to list of diagnoses");
        patientCardPage.clickDiagnosisUnit();
        return new PatientCardPageSteps(driver);
    }

    public DiagnosisFormPageSteps goToDiagnosisForm(){
        patientCardPage.clickDiagnosisUnit();
        return new DiagnosisFormPageSteps(driver);
    }

    public PatientCardPageSteps goToDiagnosisOfFirstDateMenu() {
        log.info("go to menu of the first diagnosis date from DateListOfDiagnoses");
        patientCardPage.clickFirstDateOfDiagnosisUnit();
        return new PatientCardPageSteps(driver);
    }

    public SurgeryTreatmentOfDiagnosisPageSteps goToTreatmentOfDiagnosisSurgery() {
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new SurgeryTreatmentOfDiagnosisPageSteps(driver);
    }
    //temporary ned to refactor these methods
    public ChemotherapyTreatmentPageSteps goToTreatmentOfDiagnosisChemotherapy() {
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new ChemotherapyTreatmentPageSteps(driver);
    }


    public DevicesRadiotherapyTreatmentPageSteps goToTreatmentOfDiagnosisDevicesRadioTherapy() {
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new DevicesRadiotherapyTreatmentPageSteps(driver);
    }

    public PharmacologyRadiotherapyTreatmentPageSteps goToTreatmentOfDiagnosisPharmacologyRadioTherapy() {
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new PharmacologyRadiotherapyTreatmentPageSteps(driver);
    }

    public OtherImpactTreatmentPageSteps goToTreatmentOfDiagnosisOtherImpact(){
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new OtherImpactTreatmentPageSteps(driver);
    }

    public DiagnosisFormPageSteps goToDiagnosisFormPage(){
        patientCardPage.clickEditButton();
        return new DiagnosisFormPageSteps(driver);
    }

    public PatientEditPassportDataSteps editPassportData(){
        log.info("go to passport data list");
        patientCardPage.clickEditPassportData();
        return new PatientEditPassportDataSteps(driver);
    }

    public DiagnosisFormPageSteps editDiagnosisData(){
        log.info("go to diagnosis data list");
        patientCardPage.clickEditDiagnosisData();
        return new DiagnosisFormPageSteps(driver);
    }

    public MarksOnClinicalExaminationPageSteps editClinicGroupData(){
        log.info("go to clinic group list");
        patientCardPage.clickEditClinicData();
        return new MarksOnClinicalExaminationPageSteps(driver);
    }

    public DiagnosisMetastasesMainPageSteps goToMetastasesOfDiagnosis(){
        log.info("go to relapses and metastases data");
        patientCardPage.goToMetastasesMainPage();
        return new DiagnosisMetastasesMainPageSteps(driver);
    }

    public MolecularGeneticPageSteps goToMolecularGeneticDiagnose() {
        log.info("Go to molecular genetic  diagnose");
        patientCardPage.clickDiagnoseMenuButton();
        patientCardPage.clickDiagnoseListButton();
        patientCardPage.clickMolecularGeneticDiagnoseButton();
        return new MolecularGeneticPageSteps(driver);
    }

    public NotASpecificIGHPageSteps goToIGHNotASpecificDiagnosis(){
        patientCardPage.clickDiagnoseMenuButton();
        patientCardPage.clickDiagnoseListButton();
        patientCardPage.goToNotSpecificIGHDiagnosis();
        return new NotASpecificIGHPageSteps(driver);
    }

    public SpecificIGHPageSteps goToSpecificIGHDiagnosis(){
        patientCardPage.clickDiagnoseMenuButton();
        patientCardPage.clickDiagnoseListButton();
        patientCardPage.goToSpecificIGHDiagnosis();
        return new SpecificIGHPageSteps(driver);
    }
}
