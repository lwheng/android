package com.example.fragments;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment2, container, false);
	}

	public void onStart() {
		super.onStart();

		Button btnGetText = (Button) getActivity()
				.findViewById(R.id.btnGetText);
		View.OnClickListener listener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView lbl = (TextView) getActivity().findViewById(
						R.id.lblFragment1);
				Toast.makeText(getActivity(), lbl.getText().toString(),
						Toast.LENGTH_SHORT).show();
			}
		};
		btnGetText.setOnClickListener(listener);
	}
}
