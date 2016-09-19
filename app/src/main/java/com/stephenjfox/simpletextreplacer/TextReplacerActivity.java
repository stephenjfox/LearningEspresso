package com.stephenjfox.simpletextreplacer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TextReplacerActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_text_replacer);
  }

  /**
   * Search the main text field, replacing every occurrence of the "Find" value with the "replace"
   * find value
   *
   * @param view throw away
   */
  public void replaceText(final View view) {
    final LabeledEditText findField = (LabeledEditText) findViewById(R.id.find_text_field);
    final LabeledEditText replaceField = (LabeledEditText) findViewById(R.id.replace_text_field);

    // get our labels' search criteria
    final String findFieldText = findField.getText();
    final String replaceFieldText = replaceField.getText();
    Toast.makeText(TextReplacerActivity.this,
        String.format("find = [%s], replace = [%s]", findFieldText, replaceFieldText),
        Toast.LENGTH_LONG).show();

    //
    final EditText editText = (EditText) findViewById(R.id.main_edit_text);
    final String oldText = editText.getText().toString();
    editText.setText(oldText.replace(findFieldText, replaceFieldText));
  }
}
