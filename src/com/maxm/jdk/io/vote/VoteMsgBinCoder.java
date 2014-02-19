package com.maxm.jdk.io.vote;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VoteMsgBinCoder implements VoteMsgCoder {
	// every valid msg begins with the MAGIC(01010100)
	private static final int MAGIC = 0x5400;
	private static final int RESP_FLAG = 0x0200;
	private static final int REQ_FLAG = 0x0100;
	private static final int MAGIC_MASK = 0xfc00;
	private static final int MAGIC_SHIFT = 8;

	public byte[] toByte(VoteMsg msg) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);

		short magicAndFlags = MAGIC;
		if (msg.isResp()) {
			magicAndFlags |= RESP_FLAG;
		} else if (msg.isVote()) {
			magicAndFlags |= REQ_FLAG;
		}
		dos.writeShort(magicAndFlags);
		dos.writeShort((short) msg.getCandidateId());
		if (msg.isResp()) {
			dos.writeLong(msg.getVoteCount());
		}

		return baos.toByteArray();
	}

	public VoteMsg fromByte(byte[] input) throws IOException {
		if (input.length < 4) {
			throw new IOException("wrong msg");
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(input);
		DataInputStream dis = new DataInputStream(bais);
		int magicAndFlags = dis.readShort();
		if ((magicAndFlags & MAGIC_MASK) != MAGIC) {
			throw new IOException("bad MAGIC #:"
					+ ((magicAndFlags & MAGIC_MASK) >> MAGIC_SHIFT));
		}

		boolean resp = ((magicAndFlags & RESP_FLAG) != 0);
		boolean req = ((magicAndFlags & REQ_FLAG) != 0);
		int candidateId = dis.readShort();
		long count = 0;
		if (resp) {
			count = dis.readLong();
			if (count < 0) {
				throw new IOException("bad vote count: " + count);
			}
		}

		return new VoteMsg(req, resp, candidateId, count);
	}
}
