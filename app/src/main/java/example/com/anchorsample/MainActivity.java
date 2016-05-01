package example.com.anchorsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentA();
    }

    public void setFragmentA() {
        transitionTo(new FragmentA());
    }

    public void setFragmentB() {
        transitionTo(new FragmentB());
    }

    private void transitionTo(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        View layoutButton = findViewById(R.id.layout_button);
        if (layoutButton != null) {
            ft.addSharedElement(layoutButton, getString(R.string.layout_button_transition));
        }

        fragment.setSharedElementEnterTransition(new ChangeBounds());
        fragment.setSharedElementReturnTransition(new ChangeBounds());

        ft.replace(R.id.layout_content, fragment);
        ft.commit();
    }
}
