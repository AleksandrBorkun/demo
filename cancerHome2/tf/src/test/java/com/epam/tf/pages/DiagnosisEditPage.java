package com.epam.tf.pages;

import com.epam.tf.entity.TestCase;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nikolay_Golubitsky on 12/6/2016.
 */
public class DiagnosisEditPage extends AbstractPage {

    public DiagnosisEditPage(WebDriver driver) {
        super(driver);
    }

    // Поле MKB10
    @FindBy(xpath = ".//*[@id='Mkb10Code_CatalogueField']")
    private WebElement mkb10Field;

    // Поле MKB9
    @FindBy(xpath = ".//*[@id='Mkb9_CatalogueName']")
    private WebElement mkb9Field;

    // Поле даты установления диагноза
    @FindBy(xpath = ".//*[@id='StartDate']")
    private WebElement startDateField;

    // Поле даты отмены диагноза
    @FindBy(xpath = ".//*[@id='DiscardDate']")
    private WebElement discardDateField;

    // Поле признакапарности
    @FindBy(xpath = ".//*[@id='Pair_Autocomplete']")
    private WebElement pairField;

    // Поле беременности при установлении
    @FindBy(xpath = ".//*[@id='Pregnancy_Autocomplete']")
    private WebElement pragnancyField;

    // Поле текста диагноза
    @FindBy(xpath = ".//*[@id='Text']")
    private WebElement diagnosisTextField;

    // Поле источника информации о диагнозе
    @FindBy(xpath = ".//*[@id='Source_Autocomplete']")
    private WebElement diagnosisSourceField;

    // Поле места откуда пациент поступил
    @FindBy(xpath = ".//*[@id='Clinic_CatalogueField']")
    private WebElement clinicField;

    // Поле места проживания
    @FindBy(xpath = ".//*[@id='Residence_CatalogueField']")
    private WebElement homeAddressField;

    // Поле дополнительного текста
    @FindBy(xpath = ".//*[@id='AdditionalLocation']")
    private WebElement extraTextField;

    // Поле стадии
    @FindBy(xpath = ".//*[@id='Stage_Autocomplete']")
    private WebElement stageField;

    // Поле стадии окончания
    @FindBy(xpath = ".//*[@id='FinalStage_Autocomplete']")
    private WebElement finalStageField;

    // Поле уточнения стадии
    @FindBy(xpath = ".//*[@id='AdditionalStage_Autocomplete']")
    private WebElement specificationStageField;

    // Поле уточнения стадии(окончат.)
    @FindBy(xpath = ".//*[@id='AdditionalFinalStage_Autocomplete']")
    private WebElement finalSpetificationStageField;

    // Поле T
    @FindBy(xpath = ".//*[@id='T_Autocomplete']")
    private WebElement tField;

    // Поле N
    @FindBy(xpath = ".//*[@id='N_Autocomplete']")
    private WebElement nField;

    // Поле M
    @FindBy(xpath = ".//*[@id='M_Autocomplete']")
    private WebElement mField;

    // Поле множественности
    @FindBy(xpath = ".//*[@id='Multiply_Autocomplete']")
    private WebElement multiplyField;

    // Поле условия выявления
    @FindBy(xpath = ".//*[@id='Condition_Autocomplete']")
    private WebElement conditionField;

    // Поле метода подтверждения
    @FindBy(xpath = ".//*[@id='ConfirmMethod_Autocomplete']")
    private WebElement confirmMethodField;

    // Поле морфологии(MKB10)
    @FindBy(xpath = ".//*[@id='MorphologyCode10_CatalogueField']")
    private WebElement morphologyField;

    // Поле степень дифференцировки
    @FindBy(xpath = ".//*[@id='DiffDegree_Autocomplete']")
    private WebElement diffStageField;

    // Поле текст морфологии
    @FindBy(xpath = ".//*[@id='Description']")
    private WebElement descriptionField;

    // Поле номера морфологического исследования
    @FindBy(xpath = ".//*[@id='ResearchNumber']")
    private WebElement morphologyNumberField;

    // Поле даты проведения
    @FindBy(xpath = ".//*[@id='ResearhDate']")
    private WebElement researchFieldDate;

    @FindBy(xpath = ".//*[@id='form0']/div[1]")
    private WebElement errorField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    public void fillInAllFieldsFromTestCase(TestCase testCase){

        if (!testCase.getMkb10().equals("")){
            mkb10Field.clear();
            char[] mkb10Code = testCase.getMkb10().toCharArray();
            for (char symbol : mkb10Code) {
                mkb10Field.sendKeys(String.valueOf(symbol));
                ThreadSleep.waitElement(1000);
            }
        }
        if (!testCase.getDateDiag().equals("")) {
            startDateField.clear();
            startDateField.sendKeys(testCase.getDateDiag());
        }
        if (!testCase.getDateDiagCan().equals("")){
            discardDateField.clear();
            discardDateField.sendKeys(testCase.getDateDiagCan());
        }
        if (!testCase.getSignP().equals("")){
            pairField.clear();
            pairField.sendKeys(testCase.getSignP());
        }
        if (!testCase.getPregnancy().equals("")){
            pragnancyField.clear();
            pragnancyField.sendKeys(testCase.getPregnancy());
        }
        if (!testCase.getDiagnosisText().equals("")){
            diagnosisTextField.clear();
            diagnosisTextField.sendKeys(testCase.getDiagnosisText());
        }
        if (!testCase.getSourceInf().equals("")){
            diagnosisSourceField.clear();
            diagnosisSourceField.sendKeys(testCase.getSourceInf());
        }
        if (!testCase.getFrom().equals("")){
            clinicField.clear();
            clinicField.sendKeys(testCase.getFrom());
        }
        if (!testCase.getHomeAddress().equals("")){
            char[] address = testCase.getHomeAddress().toCharArray();
            for (char symbol : address) {
                homeAddressField.sendKeys(String.valueOf(symbol));
                waitForLoaderIndicatorDisapearing();
            }
            /*homeAddressField.clear();
            homeAddressField.sendKeys(testCase.getHomeAddress());*/
        }
        if (!testCase.getExtraText().equals("")){
            extraTextField.clear();
            extraTextField.sendKeys(testCase.getExtraText());
        }
        if (!testCase.getStage().equals("")){
            stageField.clear();
            stageField.sendKeys(testCase.getStage());
        }
        if (!testCase.getFinalStage().equals("")){
            finalStageField.clear();
            finalStageField.sendKeys(testCase.getFinalStage());
        }
        if (!testCase.getSpecificationStage().equals("")){
            specificationStageField.clear();
            specificationStageField.sendKeys(testCase.getSpecificationStage());
        }
        if (!testCase.getFinalSpecificationStage().equals("")){
            finalSpetificationStageField.clear();
            finalSpetificationStageField.sendKeys(testCase.getFinalSpecificationStage());
        }
        if (!testCase.getT().equals("")){
            tField.clear();
            tField.sendKeys(testCase.getT());
        }
        if (!testCase.getN().equals("")){
            nField.clear();
            nField.sendKeys(testCase.getN());
        }
        if (!testCase.getM().equals("")){
            mField.clear();
            mField.sendKeys(testCase.getM());
        }
        if (!testCase.getPlurality().equals("")){
            multiplyField.clear();
            multiplyField.sendKeys(testCase.getPlurality());
        }
        if (!testCase.getDetectionRules().equals("")){
            conditionField.clear();
            conditionField.sendKeys(testCase.getDetectionRules());
        }
        if (!testCase.getAcceptMethod().equals("")){
            confirmMethodField.clear();
            confirmMethodField.sendKeys(testCase.getAcceptMethod());
        }
        if (!testCase.getMorphology().equals("")){
            morphologyField.clear();
            morphologyField.sendKeys(testCase.getMorphology().replace(".",""));
        }
        if (!testCase.getStageDif().equals("")){
            diffStageField.clear();
            diffStageField.sendKeys(testCase.getStageDif());
        }
        if (!testCase.getMorphologyText().equals("")){
            descriptionField.clear();
            descriptionField.sendKeys(testCase.getMorphologyText());
        }
        if (!testCase.getMorphologyNumber().equals("")){
            morphologyNumberField.clear();
            morphologyNumberField.sendKeys(testCase.getMorphologyNumber());
        }
        if (!testCase.getCarriageDate().equals("")){
            researchFieldDate.clear();
            researchFieldDate.sendKeys(testCase.getCarriageDate());
        }
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void fillInAllFieldsFromTestCaseWithoutCheck(TestCase testCase){

        mkb10Field.clear();
        char[] mkb10Code = testCase.getMkb10().toCharArray();
        for (char symbol : mkb10Code) {
            mkb10Field.sendKeys(String.valueOf(symbol));
            ThreadSleep.waitElement(1000);
        }

        startDateField.clear();
        startDateField.sendKeys(testCase.getDateDiag());

        discardDateField.clear();
        discardDateField.sendKeys(testCase.getDateDiagCan());

        pairField.clear();
        pairField.sendKeys(testCase.getSignP());

        pragnancyField.clear();
        pragnancyField.sendKeys(testCase.getPregnancy());

        diagnosisTextField.clear();
        diagnosisTextField.sendKeys(testCase.getDiagnosisText());

        diagnosisSourceField.clear();
        diagnosisSourceField.sendKeys(testCase.getSourceInf());

        clinicField.clear();
        clinicField.sendKeys(testCase.getFrom());

        char[] address = testCase.getHomeAddress().toCharArray();
        for (char symbol : address) {
            homeAddressField.sendKeys(String.valueOf(symbol));
            waitForLoaderIndicatorDisapearing();
        }
            /*homeAddressField.clear();
            homeAddressField.sendKeys(testCase.getHomeAddress());*/

        extraTextField.clear();
        extraTextField.sendKeys(testCase.getExtraText());

        stageField.clear();
        stageField.sendKeys(testCase.getStage());

        finalStageField.clear();
        finalStageField.sendKeys(testCase.getFinalStage());

        specificationStageField.clear();
        specificationStageField.sendKeys(testCase.getSpecificationStage());

        finalSpetificationStageField.clear();
        finalSpetificationStageField.sendKeys(testCase.getFinalSpecificationStage());

        tField.clear();
        tField.sendKeys(testCase.getT());

        nField.clear();
        nField.sendKeys(testCase.getN());

        mField.clear();
        mField.sendKeys(testCase.getM());

        multiplyField.clear();
        multiplyField.sendKeys(testCase.getPlurality());

        conditionField.clear();
        conditionField.sendKeys(testCase.getDetectionRules());

        confirmMethodField.clear();
        confirmMethodField.sendKeys(testCase.getAcceptMethod());

        morphologyField.clear();
        morphologyField.sendKeys(testCase.getMorphology().replace(".",""));

        diffStageField.clear();
        diffStageField.sendKeys(testCase.getStageDif());


        descriptionField.clear();
        descriptionField.sendKeys(testCase.getMorphologyText());

        morphologyNumberField.clear();
        morphologyNumberField.sendKeys(testCase.getMorphologyNumber());

        researchFieldDate.clear();
        researchFieldDate.sendKeys(testCase.getCarriageDate());

        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }


    public String getErrorMessage() {
        return errorField.getText();
    }

}
