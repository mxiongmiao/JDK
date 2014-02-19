package com.maxm.jdk.io.vote;

import java.io.IOException;

public interface VoteMsgCoder {

	byte[] toByte(VoteMsg msg) throws IOException;

	VoteMsg fromByte(byte[] input) throws IOException;
}
