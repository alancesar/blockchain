package org.alancesar.blockchain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BlockChainTest {

    @Test
    public void blockChainTest() {
        Transaction firstTransaction = new Transaction("My first transaction ever!");
        Block genesisBlock = Block.createGenesisBlock(Arrays.asList(firstTransaction));
        Assert.assertEquals(genesisBlock.getHash(), -209303716);

        Transaction secondTransaction = new Transaction("129292a182136a35e1f89c586dbac2e2");
        Block secondBlock = new Block(Arrays.asList(secondTransaction), genesisBlock);
        Assert.assertEquals(secondBlock.getHash(), 1228451966);

        Block thirdBlock = new Block(Arrays.asList(
            new Transaction("http://releases.ubuntu.com/18.04/ubuntu-18.04-desktop-amd64.iso"),
            new Transaction("http://releases.ubuntu.com/18.04/ubuntu-18.04-desktop-amd64.iso.torrent")
        ), secondBlock);

        Assert.assertEquals(thirdBlock.getHash(), -1716700900);
    }
}
