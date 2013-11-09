UWSTTester
==========

UWST���g����UI�e�X�g�����s����c�[��

�����l�t�����X�g�̍��Ԃ��S�ĂP�Ȃ̂�Markdown�̖͂����̂ł��B
���߂�Ȃ����ł��B


USAGE
=====


1. �\�[�X�����[�J���ɃN���[������

```
git clone http://10.146.225.140:8008/gitbucket/git/nemoto/UWSCTester.git
```

2. UWSC.exe�ւ̃p�X��ҏW�i���̎菇�͌�X�폜�������j

�`�F�b�N�A�E�g�����v���W�F�N�g��src / main / groovy / org / kaakaa / uwsc / exec / Executer.groovy ����
UWSC.exe�t�@�C���ւ̃p�X�������̊��ɍ����悤�ɐݒ肷��

3. �r���h

�v���W�F�N�g�̃g�b�v�f�B���N�g���ŉ��L�R�}���h�����s����B
�iGradle Wrapper���g�p���Ă���̂�Gradle���C���X�g�[������K�v�͂���܂���B
�����r���h�ɕK�v�ȏ����_�E�����[�h���邽�߁A�������Ԃ�������܂��B�j

```
gradlew.bat jar
```

4. �e�X�g���s

�o�b�`���N������ƃT���v���v���O����������܂��B
�inotepad���N�����āA���̃E�B���h�E�^�C�g�����e�X�g����X�N���v�g�j

```
exec.bat
```

HOW TO WRITE TEST CODE
======================

��{�I�ɂ̓T���v����uwsc.groovy���Q�l�ɁB
�e�X�g�X�N���v�g�́uscript�v�u���b�N�Ɓuassert�v�u���b�N�ɑ�ʂ����

�uscript�v�u���b�N�Ŏw�肳�ꂽUWSC�X�N���v�g�����s���A���s��ɑI������Ă���A�N�e�B�u�E�B���h�E�ɑ΂���
�uassert�v�u���b�N�ɋL�q�����e�X�g�����s����C���[�W

SCRIPT
------

�X�N���v�g�u���b�N�Ŏ��s����X�N���v�g�̎w����@�͂Q��ނ���B

1. UWSC�X�N���v�g���ڎw��

�X�N���v�g�u���b�N����"$" �Ŏn�܂�s��ǉ�����ƁA�����ɂ�UWSC�X�N���v�g�𒼐ڋL�q�ł���

```
script {
	$ MMV(1659,1119,10)
	$ KBD(VK_D,UP,94)
}
```

2. UWSC�X�N���v�g�t�@�C���w��

"f"�Ŏn�܂�s�ł́AUWSC�X�N���v�g�t�@�C�����w�肷�邱�Ƃ��ł���B

�܂��A�t�@�C�����w�肷��ꍇ�A��Q�����Ƃ���true���w�肷���UWSC�ł̃}�E�X�ړ��R�}���h�iMMV�j��
�ȗ������`�ŃX�N���v�g�����s�ł���

```
script {
	$ MMV(1659,1119,10)
	$ KBD(VK_D,UP,94)
	f "${new File('.','sample.UWS').absolutePath", true
}
```

ASSERT
------

�uscirpt�v�u���b�N�ɋL�q���ꂽ��ɃA�N�e�B�u�ȏ�ԂƂȂ��Ă���E�B���h�E�ɑ΂���
Assertion���L�q����u���b�N�B

������ł�assertTitle���炢�����܂Ƃ��ɓ��삵�܂���B

1. assertTitle

assertTitle�̈����Ƃ��ė\���l���w�肷��

```
assertUWSC {
	assertTitle('���� - ������')
}
```


TODO
====

- Test Suite�@�\
- ���ʏo�͂ɂ���
- UWSC.Test�Ƃ����������łȂ��A�����Ɗȗ��������utests�v�utest�v�Ƃ������������ł���悤�ɂ���
- UWSC.exe�̎w����@�̊ȗ���
