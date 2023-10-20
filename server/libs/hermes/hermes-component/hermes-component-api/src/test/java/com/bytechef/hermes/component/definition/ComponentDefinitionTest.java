
/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.hermes.component.definition;

import com.bytechef.hermes.definition.Option;
import com.bytechef.hermes.definition.Property;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author Ivica Cardic
 */
public class ComponentDefinitionTest {

    private final ObjectMapper objectMapper = new ObjectMapper() {
        {
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            registerModule(new JavaTimeModule());
            registerModule(new Jdk8Module());
        }
    };

    @Test
    public void testActionDefinition() throws JSONException, JsonProcessingException {
        ActionDefinition action = ComponentDSL.action("name")
            .title("title")
            .description("description");

        jsonAssertEquals(
            """
                {"batch":null,"deprecated":null,"description":"description","sampleOutput":null,"help":null,"name":"name","outputSchema":null,"properties":null,"sampleOutputDataSource":null,"outputSchemaDataSource":null,"title":"title"}
                """,
            action);
    }

    @Test
    public void testArrayProperty() throws JSONException, JsonProcessingException {
        Property<Property.ArrayProperty> property = ComponentDSL.array("name")
            .defaultValue(1, 2)
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true)
            .items(ComponentDSL.string());

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"ARRAY","defaultValue":[1,2],"exampleValue":null,"items":[{"advancedOption":null,"description":null,"displayCondition":null,"hidden":null,"label":null,"placeholder":null,"required":null,"name":null,"type":"STRING","defaultValue":null,"exampleValue":null,"controlType":"INPUT_TEXT","options":null,"optionsDataSource":null,"sampleDataType":null,"expressionEnabled":null}],"multipleValues":true,"options":null,"optionsDataSource":null,"controlType":"OBJECT_BUILDER","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testBooleanProperty() throws JSONException, JsonProcessingException {
        Property<Property.BooleanProperty> property = ComponentDSL.bool("name")
            .defaultValue(true)
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"BOOLEAN","defaultValue":true,"exampleValue":null,"options":[{"description":null,"displayCondition":null,"name":"True","value":true},{"description":null,"displayCondition":null,"name":"False","value":true}],"controlType":"CHECKBOX","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testComponentDefinition() throws JSONException, JsonProcessingException {
        ComponentDefinition componentDefinition = ComponentDSL.component("name")
            .title("title")
            .description("description")
            .icon("icon")
            .version(1);

        jsonAssertEquals(
            """
                {"actions":null,"category":null,"connection":null,"customAction":null,"customActionHelp":null,"description":"description","icon":"icon","tags":null,"name":"name","resources":null,"version":1,"title":"title","triggers":null}
                  """,
            componentDefinition);
    }

    @Test
    public void testDateProperty() throws JSONException, JsonProcessingException {
        Property<Property.DateProperty> property = ComponentDSL.date("name")
            .defaultValue(LocalDate.MIN)
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"DATE","defaultValue":[-999999999,1,1],"exampleValue":null,"options":null,"optionsDataSource":null,"controlType":"DATE","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testDateTimeProperty() throws JSONException, JsonProcessingException {
        Property<Property.DateTimeProperty> property = ComponentDSL.dateTime("name")
            .defaultValue(LocalDateTime.MIN)
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"DATE_TIME","defaultValue":[-999999999,1,1,0,0],"exampleValue":null,"options":null,"optionsDataSource":null,"controlType":"DATE_TIME","expressionEnabled":null}
                 """,
            property);
    }

    @Test
    public void testIntegerProperty() throws JSONException, JsonProcessingException {
        Property<Property.IntegerProperty> property = ComponentDSL.integer("name")
            .defaultValue(2)
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"INTEGER","defaultValue":2,"exampleValue":null,"maxValue":null,"minValue":null,"options":null,"optionsDataSource":null,"controlType":"INPUT_INTEGER","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testNumberProperty() throws JSONException, JsonProcessingException {
        Property<Property.NumberProperty> property = ComponentDSL.number("name")
            .defaultValue(2)
            .description("description")
            .label("label")
            .options(ComponentDSL.option("option1", 1), ComponentDSL.option("option2", 2))
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"NUMBER","defaultValue":2.0,"exampleValue":null,"maxValue":null,"minValue":null,"numberPrecision":null,"options":[{"description":null,"displayCondition":null,"name":"option1","value":1},{"description":null,"displayCondition":null,"name":"option2","value":2}],"optionsDataSource":null,"controlType":"SELECT","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testObjectProperty() throws JSONException, JsonProcessingException {
        Property<Property.ObjectProperty> property = ComponentDSL.object("name")
            .defaultValue(Map.of("key", Map.of("key1", "value1")))
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"OBJECT","defaultValue":{"key":{"key1":"value1"}},"exampleValue":null,"additionalProperties":null,"multipleValues":true,"objectType":null,"options":null,"optionsDataSource":null,"properties":null,"controlType":"OBJECT_BUILDER","expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testOneOfProperty() throws JSONException, JsonProcessingException {
        Property<Property.OneOfProperty> property = ComponentDSL.oneOf("name")
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true)
            .types(ComponentDSL.string());

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"ONE_OF","types":[{"advancedOption":null,"description":null,"displayCondition":null,"hidden":null,"label":null,"placeholder":null,"required":null,"name":null,"type":"STRING","defaultValue":null,"exampleValue":null,"controlType":"INPUT_TEXT","options":null,"optionsDataSource":null,"sampleDataType":null,"expressionEnabled":null}],"expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testStringProperty() throws JSONException, JsonProcessingException {
        Property<Property.StringProperty> property = ComponentDSL.string("name")
            .defaultValue("defaultValue")
            .description("description")
            .label("label")
            .placeholder("placeholder")
            .required(true);

        jsonAssertEquals(
            """
                {"advancedOption":null,"description":"description","displayCondition":null,"hidden":null,"label":"label","placeholder":"placeholder","required":true,"name":"name","type":"STRING","defaultValue":"defaultValue","exampleValue":null,"controlType":"INPUT_TEXT","options":null,"optionsDataSource":null,"sampleDataType":null,"expressionEnabled":null}
                """,
            property);
    }

    @Test
    public void testPropertyOption() throws JSONException, JsonProcessingException {
        Option option = ComponentDSL.option("name", 1);

        jsonAssertEquals(
            """
                {"description":null,"displayCondition":null,"name":"name","value":1}
                """,
            option);

        option = ComponentDSL.option("name", "value");

        jsonAssertEquals(
            """
                {"description":null,"displayCondition":null,"name":"name","value":"value"}
                """,
            option);

        option = ComponentDSL.option("name", 1, "description");

        jsonAssertEquals(
            """
                {"description":"description","displayCondition":null,"name":"name","value":1}
                """,
            option);

        option = ComponentDSL.option("name", "value", "description");

        jsonAssertEquals(
            """
                {"description":"description","displayCondition":null,"name":"name","value":"value"}
                """,
            option);
    }

    private void jsonAssertEquals(String expectedString, Object jsonObject)
        throws JSONException, JsonProcessingException {
        JSONAssert.assertEquals(expectedString, objectMapper.writeValueAsString(jsonObject), true);
    }
}
