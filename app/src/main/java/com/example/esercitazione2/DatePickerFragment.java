package com.example.esercitazione2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    private Calendar date;

     public static DatePickerFragment newInstance() {
            DatePickerFragment frag = new DatePickerFragment();
            Bundle args = new Bundle();
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final DatePicker datepicker = new DatePicker(getActivity());
            date = Calendar.getInstance();
            return new AlertDialog.Builder(getActivity())
                    .setView(datepicker)
                    .setPositiveButton(R.string.alert_dialog_ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    date.set(Calendar.YEAR, datepicker.getYear());
                                    date.set(Calendar.MONTH, datepicker.getMonth());
                                    date.set(Calendar.DAY_OF_MONTH, datepicker.getDayOfMonth());
                                    ((MainActivity)getActivity()).updateDataNascita(date);
                                    ((MainActivity)getActivity()).doPositiveClick(date);
                                }
                            }
                    )
                    .setNegativeButton(R.string.alert_dialog_cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ((MainActivity)getActivity()).doNegativeClick();
                                }
                            }
                    )
                    .create();
        }


    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}