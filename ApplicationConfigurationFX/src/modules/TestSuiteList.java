/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author home
 */
public class TestSuiteList {
    
    private String ModuleName;
    private String ScenarionName;
    private String TestCaseName;
    private String TestCaseDescription;
    private String ExecutionFlag;

    public TestSuiteList(String ModuleName, String ScenarionName, String TestCaseName, String TestCaseDescription, String ExecutionFlag) {
        this.ModuleName = ModuleName;
        this.ScenarionName = ScenarionName;
        this.TestCaseName = TestCaseName;
        this.TestCaseDescription = TestCaseDescription;
        this.ExecutionFlag = ExecutionFlag;
    }

    /**
     * @return the ModuleName
     */
    public String getModuleName() {
        return ModuleName;
    }

    /**
     * @param ModuleName the ModuleName to set
     */
    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }

    /**
     * @return the ScenarionName
     */
    public String getScenarionName() {
        return ScenarionName;
    }

    /**
     * @param ScenarionName the ScenarionName to set
     */
    public void setScenarionName(String ScenarionName) {
        this.ScenarionName = ScenarionName;
    }

    /**
     * @return the TestCaseName
     */
    public String getTestCaseName() {
        return TestCaseName;
    }

    /**
     * @param TestCaseName the TestCaseName to set
     */
    public void setTestCaseName(String TestCaseName) {
        this.TestCaseName = TestCaseName;
    }

    /**
     * @return the TestCaseDescription
     */
    public String getTestCaseDescription() {
        return TestCaseDescription;
    }

    /**
     * @param TestCaseDescription the TestCaseDescription to set
     */
    public void setTestCaseDescription(String TestCaseDescription) {
        this.TestCaseDescription = TestCaseDescription;
    }

    /**
     * @return the ExecutionFlag
     */
    public String getExecutionFlag() {
        return ExecutionFlag;
    }

    /**
     * @param ExecutionFlag the ExecutionFlag to set
     */
    public void setExecutionFlag(String ExecutionFlag) {
        this.ExecutionFlag = ExecutionFlag;
    }
    
}
