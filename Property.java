class Property {
    private String propertyId;
    private String type;
    private String address;
    private double price;
    private String status;
    private String sellerEmail;
    private String sellerPhoneNumber;

    public Property(String propertyId, String type, String address, double price, String status, String sellerEmail, String sellerPhoneNumber) {
        this.propertyId = propertyId;
        this.type = type;
        this.address = address;
        this.price = price;
        this.status = status;
        this.sellerEmail = sellerEmail;
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public String getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public void setSellerPhoneNumber(String sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyId='" + propertyId + '\'' + ", address='" + address + '\'' + ", price=" + price + "}";
    }
}