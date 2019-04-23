# README

This is a imitation to cloud music.

### Development Specification

1. 所有用到Intent的地方必须使用BaseActivity中getIntent(Context context, Class<?> cls)方法来构建Intent对象，以便于进行callClass的 查找。