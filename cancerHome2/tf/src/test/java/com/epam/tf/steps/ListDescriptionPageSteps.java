package com.epam.tf.steps;


import com.epam.tf.pages.ListDescriptionPage;
import org.openqa.selenium.WebDriver;
import com.epam.tf.utils.Random;

public class ListDescriptionPageSteps extends AbstractSteps{
    private ListDescriptionPage listDescriptionPage;
    private String random;

    public ListDescriptionPageSteps(WebDriver driver) {
        super(driver);
        listDescriptionPage = new ListDescriptionPage(driver);
    }

    public int getPatientCount(){
        return listDescriptionPage.getPatientCount();
    }


    public void removeFirstUser(){
        listDescriptionPage.removeFirstUser();
    }

    public void editFirstUser() { 
    	listDescriptionPage.editFirstUser();
		}
    
        
    public void renameNameList(){
    	 random = "Test "+ Random.getRandomString(5);
    	 listDescriptionPage.renameNameList(random);
    }

	public Object getActualListName() {
		 return listDescriptionPage.getFirstListName();
	}

	public Object getExpectedListName() {
		return random;
	}

	
		public void getFirstListNameFromDropDownMenu() {
			log.info("choose list for transmition");
			listDescriptionPage.openList();
			listDescriptionPage.clickFirstName();
				
		}

		public void saveChangesInList() {
			log.info("SaveChanges");
			listDescriptionPage.saveChangesInList();
		}

		public void addingNotesToAnotherList() {
			log.info("addingNotesToAnotherList");
			listDescriptionPage.addingNotesToAnotherList();
					}

		public String getActualNuberOfNotesInMessage() {
			 log.info("check adding nuber of notes ");
			return listDescriptionPage.getActualNuberOfNotesInMessage();
		}

		public void closeActualPopUpWindowNuberOfNotesInMessage() {
			log.info( "close pop-up window ");
			listDescriptionPage.closeActualPopUpWindowNuberOfNotesInMessage();
		}
		
	


}

