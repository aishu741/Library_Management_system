package com.library;

public class Member {

    private int memberId;
    private String memberName;
    private String mobileNumber;
    private String email;

    public Member(int memberId,
                  String memberName,
                  String mobileNumber,
                  String email) {

        this.memberId = memberId;
        this.memberName = memberName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}