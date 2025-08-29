package com.example.navigationapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {


    public HomeFragment() {}
    private CardView card1, card2;
    private CardView selectedCard = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        card1 = view.findViewById(R.id.card1);
        card2 =view.findViewById(R.id.card2);

        card1.setOnClickListener(v -> selectCard(card1));
        card2.setOnClickListener(v -> selectCard(card2));
    }

    private void selectCard(CardView toSelect) {
        int defaultColor = ContextCompat.getColor(getContext(), R.color.white);
        int selectedBlue = ContextCompat.getColor(getContext(), R.color.blue);

        // reset previously selected card (if any)
        if (selectedCard != null && selectedCard != toSelect) {
            selectedCard.setCardBackgroundColor(defaultColor);
        }

        // apply blue to the newly selected card
        toSelect.setCardBackgroundColor(selectedBlue);

        // update tracker
        selectedCard = toSelect;
    }
    }
