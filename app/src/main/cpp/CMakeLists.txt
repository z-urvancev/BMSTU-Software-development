cmake_minimum_required(VERSION 3.22.1)

project("project1")

add_library(project1 SHARED native-lib.cpp)

add_library(spdlog STATIC IMPORTED)
set_target_properties(spdlog PROPERTIES IMPORTED_LOCATION
        /Users/zurvantsev/AndroidStudioProjects/project1/libs/spdlog/build/${ANDROID_ABI}/libspdlog.a)

target_include_directories(project1 PUBLIC
        /Users/zurvantsev/AndroidStudioProjects/libs/spdlog/spdlog/include)

add_library(mbedcrypto SHARED IMPORTED)
set_target_properties(mbedcrypto PROPERTIES IMPORTED_LOCATION
        ${CMAKE_CURRENT_SOURCE_DIR}/../nativeLibs/${ANDROID_ABI}/libmbedcrypto.so)

target_include_directories(project1 PUBLIC
        /Users/zurvantsev/AndroidStudioProjects/libs/spdlog/spdlog/include
        /Users/zurvantsev/AndroidStudioProjects/libs/mbedtls/mbedtls/include
        )

find_library(log-lib log)

target_link_libraries(project1 spdlog mbedcrypto ${log-lib})