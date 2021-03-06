package com.messageapp.warmtalk;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.ProgressDialog;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.messageapp.warmtalk.R;
        import com.messageapp.warmtalk.ReusableCodeForAll.ReusableCodeForAll;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.android.material.textfield.TextInputLayout;
        import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout forgetpassword;
    TextView Reset;
    FirebaseAuth FAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgetpassword = (TextInputLayout) findViewById(R.id.Emailid);
        Reset = (TextView) findViewById(R.id.button2);

        FAuth = FirebaseAuth.getInstance();
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(ForgotPassword.this);
                mDialog.setCanceledOnTouchOutside(false);
                mDialog.setCancelable(false);
                mDialog.setMessage("Вход в систему...");
                mDialog.show();

                FAuth.sendPasswordResetEmail(forgetpassword.getEditText().getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            mDialog.dismiss();
                            ReusableCodeForAll.ShowAlert(ForgotPassword.this,"","Пароль был отправлен на Вашу электронную почту");
                        } else {
                            mDialog.dismiss();
                            ReusableCodeForAll.ShowAlert(ForgotPassword.this,"Ошибка",task.getException().getMessage());
                        }
                    }
                });
            }
        });


    }
}
