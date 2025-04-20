package com.example.done

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit

class Views : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                LoanDashboard()
            }
        }
    }

    @Composable
    fun LoanDashboard() {
        val context = this
        val sharedPref = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val phone = sharedPref.getString("phone", "") ?: ""
        val loanLimit = 50000 // Example loan limit
        val availableLoans = listOf(
            "Loan Offer 1: Ksh 10,000 for 6 months",
            "Loan Offer 2: Ksh 20,000 for 12 months",
            "Loan Offer 3: Ksh 30,000 for 18 months"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Greeting the user with their phone number
            Text(
                text = "Hi, $phone",
                style = TextStyle(fontSize = 22.sp, color = Color.Black),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Showing loan limit
            Text(
                text = "Loan Limit: Ksh $loanLimit",
                style = TextStyle(fontSize = 20.sp, color = Color.Gray),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Available Loan Offers
            Text(
                text = "Available Loan Offers:",
                style = TextStyle(fontSize = 18.sp, color = Color.Black),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Displaying each loan offer inside a Box
            availableLoans.forEach { loan ->
                LoanBox(loan)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Apply Loan Button
            Button(
                onClick = {
                    // Navigate to LoanActivity when the user clicks "Apply for Loan"
                    context.startActivity(Intent(context, LoanActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Apply for Loan")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Logout Button
            Button(
                onClick = {
                    // Log out user and go back to the login screen
                    sharedPref.edit { putBoolean("isLoggedIn", false) }
                    context.startActivity(Intent(context, LoginActivity::class.java))
                    finish()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Logout")
            }
        }
    }

    // Composable function to display each loan offer inside a Box
    @Composable
    fun LoanBox(loanDetails: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = loanDetails,
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }
    }
}
