package com.tomclaw.appsend.main.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.tomclaw.appsend.util.Unobfuscatable;

/**
 * Created by solkin on 17/03/2018.
 */
public class ProfileResponse implements Parcelable, Unobfuscatable {

    private int status;
    private Profile profile;
    private int[] grant_roles;

    protected ProfileResponse(Parcel in) {
        status = in.readInt();
        profile = in.readParcelable(Profile.class.getClassLoader());
        grant_roles = in.createIntArray();
    }

    public int getStatus() {
        return status;
    }

    public Profile getProfile() {
        return profile;
    }

    public int[] getGrantRoles() {
        return grant_roles;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeParcelable(profile, flags);
        dest.writeIntArray(grant_roles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProfileResponse> CREATOR = new Creator<ProfileResponse>() {
        @Override
        public ProfileResponse createFromParcel(Parcel in) {
            return new ProfileResponse(in);
        }

        @Override
        public ProfileResponse[] newArray(int size) {
            return new ProfileResponse[size];
        }
    };

}
