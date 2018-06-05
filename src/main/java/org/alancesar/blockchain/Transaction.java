package org.alancesar.blockchain;

public class Transaction {

    private final String content;

    public Transaction(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
