package com.maxm.jdk.io.vote;

import java.util.HashMap;
import java.util.Map;

public class VoteService {

	private Map<Integer, Long> rets = new HashMap<>();

	public VoteMsg handleReq(VoteMsg msg) {
		if (msg.isResp()) {
			return msg;
		}
		// 查询请求
		msg.setResp(true);
		int cid = msg.getCandidateId();
		Long count = rets.get(cid);
		if (count == null) {
			count = 0L;
		}
		// 投票
		if (msg.isVote()) {
			rets.put(cid, count++);
		}
		msg.setVoteCount(count);
		return msg;
	}
}
