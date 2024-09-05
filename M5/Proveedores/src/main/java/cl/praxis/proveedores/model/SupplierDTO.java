package cl.praxis.proveedores.model;

public class SupplierDTO {
    private int supplierId;
    private String name;
    private int rut;
    private String address;
    private String email;
    private int phoneNumber;
    private String contact;
    private int contactPhone;

    public SupplierDTO() {}

    public SupplierDTO(int supplierId, String name, int rut, String address, String email, int phoneNumber, String contact, int contactPhone) {
        this.supplierId = supplierId;
        this.name = name;
        this.rut = rut;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contact = contact;
        this.contactPhone = contactPhone;
    }

    public SupplierDTO(String name, int rut, String address, String email, int phoneNumber, String contact, int contactPhone) {
        this.name = name;
        this.rut = rut;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contact = contact;
        this.contactPhone = contactPhone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }
}
