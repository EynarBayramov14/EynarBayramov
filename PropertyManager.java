import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

class PropertyManager {
    private Map<String, Property> properties;



    public PropertyManager() {
        properties = new HashMap<>();
    }

    public void addProperty(Property property) throws IOException {
        properties.put(property.getPropertyId(), property);
        BufferedWriter writer = new BufferedWriter(new FileWriter("properties.txt"));
        writer.write(property.toString());
    }

    public Property getPropertyById(String propertyId) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("properties.txt"));
        reader.readLine();
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            if (fields[0].equals(propertyId)) {
                return new Property(fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), fields[4], fields[5], fields[6]);
            }
            line = reader.readLine();
        }
        return null;
    }

    public Map<String, Property> getAllProperties() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("properties.txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            properties.put(fields[0], new Property(fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), fields[4], fields[5], fields[6]));
            line = reader.readLine();
        }
        return properties;
    }

    public Map<String, Property> getArchivedProperties() {
        return new HashMap<>();
    }

    public Property getPropertyBySellerEmail(String sellerEmail) {
        return properties.values().stream().filter(property -> property.getSellerEmail().equals(sellerEmail)).findFirst().orElse(null);
    }

    public void saveAllPropertiesToFile() throws IOException {
        System.out.println("Saving all properties to file...");
        properties.forEach((propertyId, property) -> System.out.println(property));
        BufferedWriter writer = new BufferedWriter(new FileWriter("properties.txt"));
        properties.forEach((propertyId, property) -> {
            try {
                writer.write(property.toString());
                writer.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        writer.flush();
        System.out.println("Properties saved to file.");
    }

    }
