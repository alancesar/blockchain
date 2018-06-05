package org.alancesar.blockchain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Block {

    private final List<Transaction> transactions;
    private final int hash;
    private final int previousBlockHash;

    public Block(List<Transaction> transactions, Block previousBlock) {
        this.transactions = new ArrayList<>(transactions);
        this.previousBlockHash = previousBlock.hash;
        this.hash = Arrays.hashCode(new Object[] { transactions, this.previousBlockHash });
    }

    private Block(List<Transaction> transactions) {
        this.transactions = new ArrayList<>(transactions);
        this.previousBlockHash = 0;
        this.hash = transactions.hashCode();
    }

    public static Block createGenesisBlock(List<Transaction> transactions) {
        return new Block(transactions);
    }

    public int getHash() {
        return hash;
    }

    public int getPreviousBlockHash() {
        return previousBlockHash;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
