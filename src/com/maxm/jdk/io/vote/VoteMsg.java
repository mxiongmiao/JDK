package com.maxm.jdk.io.vote;

public class VoteMsg {
	private boolean vote;
	private boolean resp;
	private int candidateId;
	private long voteCount;

	public VoteMsg(boolean vote, boolean resp, int candidateId, long voteCount) {
		super();
		if (!resp && voteCount != 0) {
			// 查询消息不应该带票数
			throw new IllegalArgumentException("voteCount of req must be zero");
		}
		checkCandidateId(candidateId);
		if (voteCount < 0) {
			throw new IllegalArgumentException("voteCount must >= zero");
		}
		this.vote = vote;
		this.resp = resp;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public boolean isResp() {
		return resp;
	}

	public void setResp(boolean resp) {
		this.resp = resp;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		checkCandidateId(candidateId);
		this.candidateId = candidateId;
	}

	private void checkCandidateId(int candidateId) {
		if (candidateId < 0 || candidateId > 1000) {
			throw new IllegalArgumentException("candidateId scale is [0, 1000)");
		}
	}

	public long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}

	@Override
	public String toString() {
		return "VoteMsg [vote=" + vote + ", resp=" + resp + ", candidateId="
				+ candidateId + ", voteCount=" + voteCount + "]";
	}

}
