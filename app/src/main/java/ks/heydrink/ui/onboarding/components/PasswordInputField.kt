package ks.heydrink.ui.onboarding.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ks.heydrink.ui.theme.colorPurple


@Composable
fun PasswordInputField(
    value: String, // текущее значение текста
    onValueChange: (String) -> Unit, // колбэк, вызываемый при изменении текста
    hint: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false // флаг ошибки
) {
    var visible by remember { mutableStateOf(false) } // состояние, которое хранит, показывать пароль или нет, сохраняет это значение между перерисовками

    LoginInputField(
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        modifier = modifier,
        isError = isError,
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(
                onClick = { visible = !visible },
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Icon(
                    imageVector = if (visible)
                        Icons.Outlined.VisibilityOff
                    else
                        Icons.Outlined.Visibility,
                    contentDescription = null,
                    tint = colorPurple
                )
            }
        }
    )
}