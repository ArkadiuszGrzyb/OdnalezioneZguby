package org.example.odnalezionezguby.xml;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "datasets", namespace = "urn:otwarte-dane:harvester:1.13")
@XmlAccessorType(XmlAccessType.FIELD)
public class Datasets {

    @XmlElement(name = "dataset")
    private Dataset dataset;

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Dataset {
    @XmlAttribute
    private String status;

    private String extIdent;
    private Title title;
    private Description description;

    private String updateFrequency;
    private boolean hasDynamicData;
    private boolean hasHighValueData;
    private boolean hasHighValueDataFromEuropeanCommissionList;
    private boolean hasResearchData;

    private Categories categories;
    private Resources resources;
    private Tags tags;

    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getExtIdent() { return extIdent; }
    public void setExtIdent(String extIdent) { this.extIdent = extIdent; }

    public Title getTitle() { return title; }
    public void setTitle(Title title) { this.title = title; }

    public Description getDescription() { return description; }
    public void setDescription(Description description) { this.description = description; }

    public String getUpdateFrequency() { return updateFrequency; }
    public void setUpdateFrequency(String updateFrequency) { this.updateFrequency = updateFrequency; }

    public boolean isHasDynamicData() { return hasDynamicData; }
    public void setHasDynamicData(boolean hasDynamicData) { this.hasDynamicData = hasDynamicData; }

    public boolean isHasHighValueData() { return hasHighValueData; }
    public void setHasHighValueData(boolean hasHighValueData) { this.hasHighValueData = hasHighValueData; }

    public boolean isHasHighValueDataFromEuropeanCommissionList() { return hasHighValueDataFromEuropeanCommissionList; }
    public void setHasHighValueDataFromEuropeanCommissionList(boolean val) { this.hasHighValueDataFromEuropeanCommissionList = val; }

    public boolean isHasResearchData() { return hasResearchData; }
    public void setHasResearchData(boolean hasResearchData) { this.hasResearchData = hasResearchData; }

    public Categories getCategories() { return categories; }
    public void setCategories(Categories categories) { this.categories = categories; }

    public Resources getResources() { return resources; }
    public void setResources(Resources resources) { this.resources = resources; }

    public Tags getTags() { return tags; }
    public void setTags(Tags tags) { this.tags = tags; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Title {
    private String polish;
    private String english;

    public String getPolish() { return polish; }
    public void setPolish(String polish) { this.polish = polish; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Description {
    private String polish;
    private String english;

    public String getPolish() { return polish; }
    public void setPolish(String polish) { this.polish = polish; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Categories {
    @XmlElement(name = "category")
    private List<String> category;

    public List<String> getCategory() { return category; }
    public void setCategory(List<String> category) { this.category = category; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Resources {
    @XmlElement(name = "resource")
    private List<Resource> resource;

    public List<Resource> getResource() { return resource; }
    public void setResource(List<Resource> resource) { this.resource = resource; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Resource {
    @XmlAttribute
    private String status;

    private String extIdent;
    private String url;
    private Title title;
    private Description description;
    private String availability;
    private String dataDate;
    private SpecialSigns specialSigns;

    private boolean hasDynamicData;
    private boolean hasHighValueData;
    private boolean hasHighValueDataFromEuropeanCommissionList;
    private boolean hasResearchData;
    private boolean containsProtectedData;

    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getExtIdent() { return extIdent; }
    public void setExtIdent(String extIdent) { this.extIdent = extIdent; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Title getTitle() { return title; }
    public void setTitle(Title title) { this.title = title; }

    public Description getDescription() { return description; }
    public void setDescription(Description description) { this.description = description; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getDataDate() { return dataDate; }
    public void setDataDate(String dataDate) { this.dataDate = dataDate; }

    public SpecialSigns getSpecialSigns() { return specialSigns; }
    public void setSpecialSigns(SpecialSigns specialSigns) { this.specialSigns = specialSigns; }

    public boolean isHasDynamicData() { return hasDynamicData; }
    public void setHasDynamicData(boolean hasDynamicData) { this.hasDynamicData = hasDynamicData; }

    public boolean isHasHighValueData() { return hasHighValueData; }
    public void setHasHighValueData(boolean hasHighValueData) { this.hasHighValueData = hasHighValueData; }

    public boolean isHasHighValueDataFromEuropeanCommissionList() { return hasHighValueDataFromEuropeanCommissionList; }
    public void setHasHighValueDataFromEuropeanCommissionList(boolean val) { this.hasHighValueDataFromEuropeanCommissionList = val; }

    public boolean isHasResearchData() { return hasResearchData; }
    public void setHasResearchData(boolean hasResearchData) { this.hasResearchData = hasResearchData; }

    public boolean isContainsProtectedData() { return containsProtectedData; }
    public void setContainsProtectedData(boolean containsProtectedData) { this.containsProtectedData = containsProtectedData; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class SpecialSigns {
    @XmlElement(name = "specialSign")
    private List<String> specialSign;

    public List<String> getSpecialSign() { return specialSign; }
    public void setSpecialSign(List<String> specialSign) { this.specialSign = specialSign; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Tags {
    @XmlElement(name = "tag")
    private List<Tag> tag;

    public List<Tag> getTag() { return tag; }
    public void setTag(List<Tag> tag) { this.tag = tag; }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Tag {
    @XmlAttribute
    private String lang;
    private String value;

    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
