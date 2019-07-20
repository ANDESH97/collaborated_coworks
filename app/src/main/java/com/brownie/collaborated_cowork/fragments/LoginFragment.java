package com.brownie.collaborated_cowork.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.brownie.collaborated_cowork.R;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "Login Fragment";

    private View view;

    private Button btnLogout, btnLogin;
    private TextView txtDetails;


    public LoginFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.login_fragment, container, false);

        computePackageHash();
        init(view);

        return view;
    }

    private void init(View view)
    {
        btnLogin = view.findViewById(R.id.btn_login);
        btnLogout = view.findViewById(R.id.btn_logout);
        txtDetails = view.findViewById(R.id.txt_details);

        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

        btnLogin.setVisibility(View.VISIBLE);
        btnLogout.setVisibility(View.GONE);
        txtDetails.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_login:
            {
                //handleLogin();
            }
            break;

            case R.id.btn_logout:
            {
                //handleLogout();
            }
            break;
        }
    }

    private void computePackageHash() {
        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    "com.brownie.collaborated_cowork",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (Exception e) {
            Log.e("TAG", e.getMessage());
        }
    }

    /*private void handleLogin()
    {
        LISessionManager.getInstance(getActivity().getApplicationContext()).init(getActivity(), buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
                btnLogin.setVisibility(View.GONE);
                btnLogout.setVisibility(View.VISIBLE);
//                imgProfile.setVisibility(View.VISIBLE);
                txtDetails.setVisibility(View.VISIBLE);
                fetchPersonalInfo();
            }
            @Override
            public void onAuthError(LIAuthError error) {
                Log.e("Ankit", error.toString());
            }
        }, true);
    }

    private void handleLogout(){
        LISessionManager.getInstance(getActivity().getApplicationContext()).clearSession();
        btnLogin.setVisibility(View.VISIBLE);
        btnLogout.setVisibility(View.GONE);
        //imgProfile.setVisibility(View.GONE);
        txtDetails.setVisibility(View.GONE);
    }


    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE, Scope.R_EMAILADDRESS);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        this.onActivityResult(requestCode, resultCode, data);
        // Add this line to your existing onActivityResult() method
        LISessionManager.getInstance(getActivity().getApplicationContext()).onActivityResult(getActivity(), requestCode, resultCode, data);
    }

    private void fetchPersonalInfo() {
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,picture-url,email-Address)?format=json";
        final APIHelper apiHelper = APIHelper.getInstance(getActivity().getApplicationContext());
        apiHelper.getRequest(getContext(), url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                // Success!
                try {
                    JSONObject jsonObject = apiResponse.getResponseDataAsJson();
                    String firstName = jsonObject.getString("firstName");
                    String lastName = jsonObject.getString("lastName");
                    String pictureURL = jsonObject.getString("pictureUrl");
                    String emailAddress = jsonObject.getString("emailAddress");
                    //Picasso.with(getActivity().getApplicationContext()).load(pictureURL).into(imgProfile);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("First Name: " +firstName);
                    stringBuilder.append("\n\n");
                    stringBuilder.append("Last Name: " +lastName);
                    stringBuilder.append("\n\n");
                    stringBuilder.append("Email Address: " +emailAddress);
                    txtDetails.setText(stringBuilder);
                    Log.d(TAG, "onApiSuccess: " + stringBuilder);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onApiError(LIApiError liApiError) {
                // Error making GET request!
                Log.e("XYZ", liApiError.getMessage());
            }
        });
    }*/


}
