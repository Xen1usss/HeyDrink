package ks.heydrink.data

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import javax.inject.Inject
import javax.inject.Qualifier

private val Context.dataStore by preferencesDataStore(name = "settings") // точка входа для работы с хранилищем

class OnboardingPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    // Итого: при каждом изменении настроек DataStore UI получит новое значение (true или false)
    val onboardingCompletedFlow: Flow<Boolean> // объявляем свойство, которое возвращает поток boolean
        get() = context.dataStore.data // DataStore отдает поток всех сохраненных пар ключ-значение
            .map { // оператор map берет каждое значение prefs и преобразует
                    prefs ->
                prefs[ONBOARDING_COMPLETED]
                    ?: false // читаем по ключу ONBOARDING_COMPLETED, если значения нет, то возвращаем false
            }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { prefs -> // suspend-функция открывает транзакцию для редактирования Preferences
            prefs[ONBOARDING_COMPLETED] = completed // внутри транзакции меняем значение по ключу
        }
    }
}
