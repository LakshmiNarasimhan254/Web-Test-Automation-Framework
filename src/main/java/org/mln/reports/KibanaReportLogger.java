package org.mln.reports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.mln.customexceptions.CustomException;
import org.mln.enums.Categories;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;


public class KibanaReportLogger {

    private KibanaReportLogger() {
    }

    static ELKReport elkReport = new ELKReport();

    private static ELKReport setReportData(String testName, String teststatus, Categories[] testCategory, String[] testAuthor, long testExecutionTime) {
        elkReport.setTestName(testName);
        elkReport.setTeststatus(teststatus);
        elkReport.setTestAuthor(testAuthor);
        elkReport.setTestCategory(testCategory);
        elkReport.setTestExecutionTime(testExecutionTime);
        return elkReport;
    }

    private static String serializeReportdata(String testName, String teststatus, Categories[] testCategory, String[] testAuthor, long testExecutionTime) {
        String serializedReportdata = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            serializedReportdata = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(
                            setReportData(
                                    testName,
                                    teststatus,
                                    testCategory,
                                    testAuthor,
                                    testExecutionTime));
        } catch (JsonProcessingException e) {
            throw new CustomException(e.getMessage());
        }
        return serializedReportdata;
    }

    public static void sendReportData(String testName, String teststatus, Categories[] testCategory, String[] testAuthor, long testExecutionTime) {

        if(PropertyUtil.getValue(ConfigProperties.SENDRESULTSTOKIBANA).equalsIgnoreCase("YES")){
            RestAssured.baseURI = PropertyUtil.getValue(ConfigProperties.KIBANAREPORTURL);
            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(serializeReportdata(
                    testName,
                    teststatus,
                    testCategory,
                    testAuthor,
                    testExecutionTime));
            Response response = requestSpecification.request(Method.POST, "");
        }


    }


}
