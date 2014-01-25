package com.example.fragments;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment1, container, false);
	}

	public void onAttach(Activity a) {
		super.onAttach(a);
		Log.d("Fragment 1", "onAttach");
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Fragment 1", "onCreate");
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("Fragment 1", "onActivityCreated");
	}

	public void onStart() {
		super.onStart();
		Log.d("Fragment 1", "onStart");
	}

	public void onResume() {
		super.onResume();
		Log.d("Fragment 1", "onResume");
	}

	public void onPause() {
		super.onPause();
		Log.d("Fragment 1", "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.d("Fragment 1", "onStop");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d("Fragment 1", "onDestroy");
	}

	public void onDetach() {
		super.onDetach();
		Log.d("Fragment 1", "onDetach");
	}

	public void onDestroyView() {
		super.onDestroyView();
		Log.d("Fragment 1", "onDestroyView");
	}

}
