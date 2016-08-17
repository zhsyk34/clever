package com.dnk.clever.door.entity.dict;

/**
 * 锁指令
 */
public enum ActionType {
	PASSWORD,//密码
	PASSWORDERROR,//密码错误

	FINGERPRINT,//指纹开锁
	FINGERPRINTERROR,//指纹错误

	KEY,//钥匙

	LOWBAT,//低电量

	BROKEN,//撬门
	NOCLOSE,//长时未关门
	HELP,//胁迫报警
	CLOSE,//闭锁
}
