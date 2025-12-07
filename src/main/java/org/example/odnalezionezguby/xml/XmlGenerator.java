package org.example.odnalezionezguby.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.odnalezionezguby.items.Item;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

public class XmlGenerator {

    /**
     * Generate XML for a given Item and write it to output.xml
     */
    public void generateXML(Item item) throws Exception {
        // --- Build Title ---
        Title title = new Title();
        title.setPolish("Dane zaginionych przedmiotow");
        title.setEnglish("Details of the missing items");

        // --- Build Description ---
        Description description = new Description();
        description.setPolish("Zbiór danych zawiera informacje o " + item.getName());
        description.setEnglish("The dataset contains information about " + item.getName());

        // --- Build Resource ---
        Resource resource = new Resource();
        resource.setStatus("published");
        resource.setExtIdent("extIdent_" + item.getId());
        resource.setUrl("https://example.com/" + item.getName() + "-" + formatDate(item.getFoundDate()) + ".csv");

        Title resourceTitle = new Title();
        resourceTitle.setPolish(item.getName() + " " + formatDate(item.getFoundDate()));
        resourceTitle.setEnglish(item.getName() + " " + formatDate(item.getFoundDate()));
        resource.setTitle(resourceTitle);

        Description resourceDesc = new Description();
        resourceDesc.setPolish("Dane dotyczące " + item.getAdditionalInfo() + " udostępnione " + formatDate(item.getFoundDate()));
        resourceDesc.setEnglish("Data concerning " + item.getAdditionalInfo() + " made available " + formatDate(item.getFoundDate()));
        resource.setDescription(resourceDesc);

        resource.setAvailability("local");
        resource.setDataDate(formatDate(item.getFoundDate()));

        SpecialSigns signs = new SpecialSigns();
        signs.setSpecialSign(List.of("X"));
        resource.setSpecialSigns(signs);

        resource.setHasDynamicData(false);
        resource.setHasHighValueData(true);
        resource.setHasHighValueDataFromEuropeanCommissionList(false);
        resource.setHasResearchData(false);
        resource.setContainsProtectedData(false);

        // --- Build Dataset ---
        Dataset dataset = new Dataset();
        dataset.setStatus("published");
        dataset.setExtIdent("dataset_" + item.getId());
        dataset.setTitle(title);
        dataset.setDescription(description);
        dataset.setUpdateFrequency("daily");
        dataset.setHasDynamicData(false);
        dataset.setHasHighValueData(true);
        dataset.setHasHighValueDataFromEuropeanCommissionList(false);
        dataset.setHasResearchData(false);

        Categories categories = new Categories();
        categories.setCategory(List.of("ECON"));
        dataset.setCategories(categories);

        Resources resources = new Resources();
        resources.setResource(List.of(resource));
        dataset.setResources(resources);

        Tag tag = new Tag();
        tag.setLang("pl");
        tag.setValue("Deweloper");
        Tags tags = new Tags();
        tags.setTag(List.of(tag));
        dataset.setTags(tags);

        // --- Wrap in root ---
        Datasets datasets = new Datasets();
        datasets.setDataset(dataset);

        // --- Marshall to XML ---
        JAXBContext context = JAXBContext.newInstance(Datasets.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Output to file
        marshaller.marshal(datasets, new File("output.xml"));
        // Or to console
        marshaller.marshal(datasets, System.out);
    }

    private String formatDate(java.util.Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}