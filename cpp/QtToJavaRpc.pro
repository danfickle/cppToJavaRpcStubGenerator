CONFIG += QT
HEADERS += \
    types_head.h \
    types_fwds.h \
    java_rpc_fwds.h \
    java_object.h \
    java_lang_throwable.h \
    java_lang_stringbuilder.h \
    java_lang_object.h \
    java_lang_exception.h \
    iobuffer.h \
    conn.h \
    coder.h \
    com_github_danfickle_cpptojavarpcstubgeneratorsvrexample_rpctest.h

SOURCES += \
    types.cc \
    sample.cc \
    java_lang_throwable.cc \
    java_lang_stringbuilder.cc \
    java_lang_object.cc \
    java_lang_exception.cc \
    iobuffer.cc \
    conn.cc \
    coder.cc \
    com_github_danfickle_cpptojavarpcstubgeneratorsvrexample_rpctest.cc

DEFINES += RPC_USE_QT
QT += network
