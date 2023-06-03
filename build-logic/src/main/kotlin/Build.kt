import org.gradle.api.JavaVersion

public object Build {
    internal const val ANDROID_COMPILE_SDK = 33
    internal const val ANDROID_MIN_SDK = 27
    internal const val ANDROID_TARGET_SDK = 33

    internal val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
    internal val TARGET_COMPATIBILITY = JavaVersion.VERSION_17
    internal val JVM_TARGET = JavaVersion.VERSION_17.toString()

    public const val NAMESPACE: String = "com.bravepeople.devevent"
}