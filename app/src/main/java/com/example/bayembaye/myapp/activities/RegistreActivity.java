package com.example.bayembaye.myapp.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bayembaye.myapp.Drivers.Drivers;
import com.example.bayembaye.myapp.R;
import com.example.bayembaye.myapp.UseObjects.User;
import com.example.bayembaye.myapp.databaseInterne.SqlHelper;
import com.example.bayembaye.myapp.databaseOnServer.ServerRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class RegistreActivity extends AppCompatActivity {
    /**
     * Declarations of the variables of registry views
   */
    RegistreTask registreTask = null;
    private View registreProgress;
    private View registreForm;

    private EditText nomReg;
    private EditText lastnameReg;
    private EditText nieReg;
    private EditText emailREg;
    private EditText passworReg;
    private EditText telReg;
    private EditText villeOrig;
    private Spinner spinnerListUniv;

    //department choice
    private static int choixdep = 0;
    //declare an hashmap to transport the data to the class ServerRequest for request
    private HashMap<String,String> hashMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        setViews();
        telReg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptRegistre();
                    return true;
                }
                return false;
            }
        });
        Button registerInbutton = (Button)findViewById(R.id.registreIn);
        registerInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegistre();
            }
        });
        spinnerListUniv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //depchoice = null;

                final String univ  = (String)spinnerListUniv.getSelectedItem();
                if (univ.toString().equals("Universite de Thies")) {
                    // DialogFragment.show() will take care of adding the fragment
                    // in a transaction.  We also want to remove any currently showing
                    // dialog, so make our own transaction and take care of that here.
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    // Create and show the dialog.
                    DialogFragment newFragment = DepartmentChoice.newInstance();
                    newFragment.show(ft, "dialog");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void setViews(){
        nomReg  =(EditText)findViewById(R.id.nomReg);
        lastnameReg = (EditText)findViewById(R.id.prenomReg);
        nieReg =  (EditText)findViewById(R.id.nieReg);
        emailREg = (EditText)findViewById(R.id.emailReg);
        passworReg =(EditText)findViewById(R.id.passwordReg);
        telReg = (EditText)findViewById(R.id.telReg);
        registreProgress = findViewById(R.id.registre_progress);
        registreForm  = findViewById(R.id.registre_form);
        spinnerListUniv = (Spinner)findViewById(R.id.universities);
        villeOrig = (EditText)findViewById(R.id.villeReg);
        hashMap = new HashMap<>();
    }


    /**
     * code for register activity and what we showing for animitions
     *
     */
    private void attemptRegistre() {
        if (registreTask != null) {
            return;
        }

        // Reset errors.
        nomReg.setError(null);
        lastnameReg.setError(null);
        nieReg.setError(null);
        emailREg.setError(null);
        passworReg.setError(null);
        telReg.setError(null);
        villeOrig.setError(null);

        // Store values at the time of the login attempt.
        String nom = nomReg.getText().toString();
        String prenom = lastnameReg.getText().toString();
        String nie = nieReg.getText().toString();
        String email = emailREg.getText().toString();
        String password = passworReg.getText().toString();
        String tel  = telReg.getText().toString();
        String ville = villeOrig.getText().toString();
        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(ville)){
            villeOrig.setError(getString(R.string.error_field_required));
            focusView = villeOrig;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passworReg.setError(getString(R.string.error_invalid_password));
            focusView = passworReg;
            cancel = true;
        }
        if (TextUtils.isEmpty(nom) || Drivers.containtNumber(nom)){
            nomReg.setError("invalid name !");
            focusView = nomReg;
            cancel = true;
        }
        if (TextUtils.isEmpty(prenom) || Drivers.containtNumber(prenom))
        {
            lastnameReg.setError("invalid last name !");
            focusView = lastnameReg;
            cancel =true;
        }
        if (TextUtils.isEmpty(nie)){
            nieReg.setError(getString(R.string.error_field_required));
            focusView = nieReg;
            cancel =true;
        }
        if (TextUtils.isEmpty(tel)){
            telReg.setError(getString(R.string.error_field_required));
            focusView = telReg;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailREg.setError(getString(R.string.error_field_required));
            focusView = emailREg;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailREg.setError(getString(R.string.error_invalid_email));
            focusView = emailREg;
            cancel = true;
        }
        // test for password
        EditText testPass = (EditText)findViewById(R.id.passwordRep);
        testPass.setError(null);
        String test = testPass.getText().toString();
        if (!isSamePassword(password,test)){
            testPass.setError("please the same password is needed here");
            focusView = testPass;
            cancel =true;
        }
        if (choixdep==0){
            cancel = true;
            focusView = null;
            Toast.makeText(getApplicationContext(),"Que suivez vous ?",Toast.LENGTH_SHORT).show();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);

            // Create and show the dialog.
            DialogFragment newFragment = DepartmentChoice.newInstance();
            newFragment.show(ft, "dialog");

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //insert data on the hashmap for Task
            hashMap.put(SqlHelper.name_user,nom);
            hashMap.put(SqlHelper.lastname_user,prenom);
            hashMap.put(SqlHelper.nie_user,nie);
            hashMap.put(SqlHelper.email_user,email);
            hashMap.put(SqlHelper.password_user,password);
            hashMap.put(SqlHelper.tel_user,tel);
            hashMap.put(SqlHelper.ville_origine,ville);
            hashMap.put(SqlHelper.id_ufr_user,choixdep+"");
            showProgress(true);
            registreTask = new RegistreTask(hashMap);
            registreTask.execute((Void) null);
        }
    }


    private boolean isEmailValid(String email) {
        return (email.length()>8) && email.contains("@") && email.contains(".") && Drivers.isValideMail(email);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            registreForm.setVisibility(show ? View.GONE : View.VISIBLE);
            registreForm.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    registreForm.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            registreProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            registreProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    registreProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            registreProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            registreForm.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    /**
     *  return true if we type two same password
     */

    private boolean isSamePassword(String referedPasswors, String passwordTest){
        return referedPasswors.equals(passwordTest);
    }

    /**
     * Displaying the list of the department of the selected university on a windows
     */

    public static class DepartmentChoice extends DialogFragment {

        /**
         * Create a new instance of MyDialogFragment, providing "num"
         * as an argument.
         */
        static DepartmentChoice newInstance() {
            DepartmentChoice f = new DepartmentChoice();
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Pick a style based on the num.
            int style = DialogFragment.STYLE_NORMAL, theme = 0;
            setStyle(style, theme);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.list_department_choice, container, false);
            ListView listView =(ListView) v.findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListDepThies);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    choixdep   =1+i;
                    onResume();
                    onStop();
                }
            });
            return v;
        }
    }

    /**
     * the background task on this activity can make few minutes
     *
     */


    public class RegistreTask extends AsyncTask<Void, Void, Boolean> {
        HashMap<String,String> hashMap;
        private String urlname = "http://10.0.2.2/insert_usermyapp.php";
        RegistreTask(HashMap<String,String> hashMap) {
        this.hashMap = hashMap;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            URL url;
            try {
                 url = new URL(urlname);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return false;
            }
            return new ServerRequest(url).newUserInsert(hashMap);
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            registreTask = null;
            showProgress(false);
            if (success) {
                Intent login = new Intent(getApplicationContext(),LoginActivity.class);
                login.putExtra(SqlHelper.email_user,hashMap.get(SqlHelper.email_user));
                startActivity(login);
                finish();
            } else {
                Toast.makeText(getApplicationContext(),"something wrong was detected please look at your" +
                        " network configuration",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onCancelled() {
            registreTask = null;
            showProgress(false);
        }
    }
}
