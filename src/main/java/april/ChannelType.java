package april;

public enum ChannelType {

    SMS("SMS", "OCP ShortMessageService"),
    EMAIL("Email", "OCP Email"),
    CHAT("Chat", "OCP Chat"),
    SOCIAL("SOCIAL", "OCP Social"),
    GENERIC("Generic", "GenericChannel"),
    MESSAGING("Messaging", "OCP Messaging");

    private final String name;

    private final String providerId;

    ChannelType(String name, String providerId) {
        this.name = name;
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public String getProviderId() {
        return providerId;
    }

    public static ChannelType fromStringValue(String channelType) {
        if ("ShortMessageService".equalsIgnoreCase(channelType)) {
            return ChannelType.SMS;
        }
        for (ChannelType ct : values()) {
            if (ct.getName().equalsIgnoreCase(channelType)) {
                return ct;
            }
        }
        throw new IllegalArgumentException("Unsupported channel " + channelType);
    }

}
